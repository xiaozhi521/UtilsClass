package com.util;

import com.util.weather.WeatherPool;

import java.util.ArrayList;
import java.util.List;

public class WeatherUtilTest {
    public static void main(String[] args) throws Exception {
        System.out.println(DateUtil.getCurrentDateForYearToHour());
        List<String> list = new ArrayList();
        list.add("丰台");
        list.add("海淀");
        list.add("朝阳");
        list.add("丰台");
        list.add("朝阳");
        list.add("东城");
        list.add("朝阳");
        //时间组成格式 ： 2018093102  注释：2018 年  09 月  30 日 02 时
        for (int i = 0; i < list.size(); i++){
            System.out.println(WeatherPool.getWeather(list.get(i),DateUtil.getCurrentDateForYearToHour()));
        }
    }
}
