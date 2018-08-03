package com.util;

import java.io.*;

import org.json.JSONObject;
import org.json.XML;

import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.zip.GZIPInputStream;

public class WeatherUtil {

    public static final String WEATHERURL1 = "https://www.sojson.com/open/api/weather/xml.shtml?city=%s";
    public static final String WEATHERURL = "http://wthrcdn.etouch.cn/WeatherApi?city=%s";

    /**
     *  获取多个城市的天气
     * @param cityList 城市数组
     * @return 返回map
     */
    public Map getWeatherList(List<String> cityList) throws Exception {
        Map<String,String> cityWeatherMap = new HashMap<>();
        if(cityList.size() > 0){
            for(String city : cityList){
                cityWeatherMap.put(city,getCityWeather(city));
            }
        }
        return cityWeatherMap;
    }
    /**
     * 获取单个城市的天气
     * @param city 城市或县或区
     * @return
     * @throws Exception
     */
    public static String getCityWeather(String city) throws Exception {
        StringBuilder builder = new StringBuilder();
        //获取当前日期
        Date date = DateUtil.parseDate(System.currentTimeMillis());
        JSONObject weather = (JSONObject) getWeatherXMLFormatJSON(city).get("resp");
        //获取当天的天气
        JSONObject currentDayWeather = (JSONObject) ((JSONObject) weather.get("forecast")).getJSONArray("weather").get(0);
        if (!StringUtil.isEmpty(currentDayWeather.get("date"))){
            builder.append("[呲牙]");
            builder.append(DateUtil.getMonth(date));
            builder.append("月");
            builder.append(currentDayWeather.get("date"));
            builder.append("[呲牙]\n");
        }
        builder.append("[玫瑰]今日");
        builder.append(city);
        builder.append("天气[玫瑰]\n");
        //多云  南风3-5级
        JSONObject day = (JSONObject) currentDayWeather.get("day");
        builder.append(day.get("type"));
        builder.append(" ");
        builder.append(day.get("fengxiang"));
        builder.append(" ");
        builder.append(day.get("fengli"));
        builder.append("\n");
//        气温：27℃~ 34℃
        builder.append("气温：");
        String high = ((String) currentDayWeather.get("high")).substring(2);
        String low = ((String) currentDayWeather.get("low")).substring(2);
        builder.append("[拥抱]");
        builder.append(low.trim());
        builder.append("~");
        builder.append(high.trim());
        builder.append("[拥抱]\n");
        //获取 environment
        if(weather.has("environment")){
            JSONObject environment = (JSONObject) weather.get("environment");
            //    空气质量：良
            builder.append("空气质量：");
            builder.append(environment.get("quality"));
            builder.append("[调皮]\n");
            //    PM2.5：69
            builder.append("PM2.5：");
            builder.append(environment.get("pm25"));
            builder.append("[调皮]\n");
        }
        return builder.toString();
    }
    /**
     *  将 XML 格式化成 JSON
     * @param city 城市名称 可以是县或者县级市或者
     * @return
     * @throws Exception
     */
    public static JSONObject getWeatherXMLFormatJSON(String city) throws Exception {
        JSONObject xmlJSONObj = XML.toJSONObject(getWeatherForXML1(city));
        //设置缩进
//       String jsonPrettyPrintString = xmlJSONObj.toString(4);
        return xmlJSONObj;
    }
    /**
     * 方法一：使用 https://www.sojson.com 获取天气信息，返回XML格式
     * @param city 城市名称 可以是县或者县级市或者
     * @return
     * @throws Exception
     */
    public static String getWeatherForXML(String city) throws Exception {
        //参数url化
        city = java.net.URLEncoder.encode(city, "utf-8");

        //拼地址
        String apiUrl = String.format(WEATHERURL1,city);
        //开始请求
        URL url= new URL(apiUrl);
        URLConnection open = url.openConnection();
        InputStream input = open.getInputStream();
        String result = org.apache.commons.io.IOUtils.toString(input,"utf-8");
        return result;
    }

    /**
     * 方法二：使用 http://wthrcdn.etouch.cn/WeatherApi 获取天气信息，返回XML格式
     * @param city
     * @return
     * @throws Exception
     */
    public static String getWeatherForXML1(String city) throws Exception {
        //参数url化
        city = java.net.URLEncoder.encode(city, "utf-8");

        //拼地址
        String apiUrl = String.format(WEATHERURL,city);
        //开始请求
        URL url= new URL(apiUrl);
        URLConnection open = url.openConnection();
        InputStream input = open.getInputStream();
//        byte[] bytes = new byte[input.available()];
//        input.read(bytes);
//        String result = new String(WeatherUtil.uncompress(bytes));
        String result = new String(WeatherUtil.uncompress(input));
        return result;
    }
    /**
     *  metgod 1 ：解压缩字符串使用main函数没有乱码，如果进行页面 url 请求会出现乱码
     * @param bytes
     * @return
     */
    public static byte[] uncompress(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        byte[] b = new byte[0];
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[1024];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            b = out.toByteArray();
            ungzip.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return b;
    }
    /**
     *  metgod 2 ：解压缩字符串 使用main函数和页面url请求均无乱码
     * @return
     */
    public static String uncompress(InputStream is) throws Exception {
        StringBuffer sb = new StringBuffer();
        GZIPInputStream gzin = new GZIPInputStream(is);
        InputStreamReader isr = new InputStreamReader(gzin, "utf-8"); // 设置读取流的编码格式，自定义编码
        java.io.BufferedReader br = new java.io.BufferedReader(isr);
        String tempbf;
        while ((tempbf = br.readLine()) != null) {
            sb.append(tempbf);
            sb.append("\r\n");
        }
        isr.close();
        gzin.close();
//        System.out.println(sb);
        return sb.toString();
    }
}
