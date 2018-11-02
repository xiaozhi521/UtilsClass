package com.util.weather;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * weather 的享元类
 */
public class WeatherPool {
    private static ConcurrentHashMap pool = new ConcurrentHashMap();

    /**
     *  享元模式，获取每小时的天气数据，
     *  比如，15:00:00 到 15:59:59 之间获取的天气数据是相同的
     * @param cityName  城市
     * @param time  时间，使用DateUtil.getCurrentDateForYearToHour()获取
     * @return
     * @throws Exception
     */
    public static String getWeather(String cityName,String time) throws Exception {
        String mapKey = cityName + time;
        String weather = (String) pool.get(mapKey);
        Set<Map.Entry<String,Integer>> entry = pool.entrySet();
        if(weather == null){
            for (Map.Entry<String, Integer> mapEntry : entry) {
                /*
                 * 以 cityName + currentTimeMillis 为键值
                 * 判断键中是否包含 cityName &&  mapEntry.getKey()== mapKey， 则移除当前key
                 */
                //获取当前对象的key值
                String key = mapEntry.getKey();
                if (key.contains(cityName)) {
                    pool.remove(mapKey);
                    break;
                }
            }
            weather = WeatherUtil.getCityWeather(cityName);
            pool.put(mapKey,weather);
        }
        return weather;
    }
    /**
     *  该方法已经实现基本的享元模式，但是不能解决时间问题
     * @param cityName
     * @return
     * @throws Exception
     */
    public static String getWeather(String cityName) throws Exception {
        String weather = (String) pool.get(cityName);
        if(weather == null){
            weather = WeatherUtil.getCityWeather(cityName);
            pool.put(cityName,weather);
        }
        return weather;
    }
}
