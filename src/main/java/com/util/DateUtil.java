package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *  日期工具类
 *  yyyy : 年
 *  MM ： 月
 *  dd ： 日
 *  hh ： 12小时制  HH : 24小时制
 *  mm ：分
 *  ss ：秒
 *  S ：毫秒
 *  csdn url ： https://blog.csdn.net/mqf163/article/details/53364092
 */
public class DateUtil {
    //创建一个代表系统当前日期的Calendar对象
    static Calendar cal = Calendar.getInstance();
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");


    /**
     *  根据时间返回时间戳
     * @param date 字符串： 例如：2016-03-10 07:18:39.763
     * @return  返回：1457565519763
     */
    public static long getTimeMillis(String date){
        return getFormatDate(date).getTime();
    }
    /**
     *
     * @param date 2016-03-10 07:18:39.763
     * @return  Thu Mar 10 07:18:39 CST 2016
     */
    public static Date getFormatDate(String date){
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 格式化时间日期
     * @return 2016-03-10 07:18:39.763
     */
    public static String getFormatDate(){
        Date d = new Date();
        return sdf.format(d);
    }
    /**
     * 格式化时间日期
     * @return 2016-03-10 07:18:39.763
     */
    public static String getFormatDate(long timeMillis){
        Date d = new Date(timeMillis);
        return sdf.format(d);
    }
    /**
     * 获取当前的时间： xxxx年xx月xx日 xx:xx:xx
     * @return
     */
    public static String getCurrentDate(){
        return cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH)+1) + "月" + cal.get(Calendar.DAY_OF_MONTH) + "日  " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE )+ ":" + cal.get(Calendar.SECOND);
    }
    /**
     * 获取当前的时间 年月日时： 201893012
     * @return
     */
    public static String getCurrentDateForYearToHour(){
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(cal.get(Calendar.YEAR)).append(cal.get(Calendar.MONTH)+1).append(cal.get(Calendar.DAY_OF_MONTH)).append(cal.get(Calendar.HOUR_OF_DAY)).toString();
    }
    /**
     * 获取当前的时间 年月日： 2018930
     * @return
     */
    public static String getCurrentDateForYearToDay(){
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(cal.get(Calendar.YEAR)).append(cal.get(Calendar.MONTH)+1).append(cal.get(Calendar.DAY_OF_MONTH)).toString();
    }
    /**
     * 获取当前分钟中的秒
     * @return
     */
    public static int getMillion(){
        return cal.get(Calendar.SECOND);
    }
    /**
     * 获取当前小时中的分钟
     * @return
     */
    public static int getMinute(){
        return cal.get(Calendar.MINUTE);
    }
    /**
     * 获取当天的第几个小时
     * @return
     */
    public static int getHour(){
        return cal.get(Calendar.HOUR_OF_DAY);

    }
    /**
     * 获取当前月中的第几天
     * @return
     */
    public static int getDay(){
        return cal.get(Calendar.DAY_OF_MONTH);
    }
    /**
     * 获取当前的月份
     * @return
     */
    public static int getMonth(Date date){
        Calendar c = Calendar.getInstance();
        if (date != null)
            c.setTime(date);
        return (c.get(2) + 1);
    }

    /**
     * 获取当前的月份
     * @return
     */
    public static int getMonth(){
        return (cal.get(Calendar.MONTH)+1);
    }
    /**
     * 获取当前的年份
     * @return
     */
    public static int getYear(){
        return cal.get(Calendar.YEAR);
    }

    /**
     * 获取某月的第几个周
     * @return int
     */
    public static int getWeekOfMonth(){
        return cal.WEEK_OF_MONTH;
    }

    /**
     * 获取当前的时间毫秒数
     * @return
     */
    public static long getCurrenTimeMillis(){
        return System.currentTimeMillis();
    }

    public static final Date parseDate(long milliSeconds) {
        return new Date(milliSeconds);
    }


    /**
     * 获取指定年月的天数
     * @param year
     * @param month
     * @return 一月的天数
     */
    public static int getDayOfMonth(int year,int month){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.get(Calendar.DATE);
    }
    /**
     * 获取指定年月的天数
     * @param date
     * @return 一月的天数
     */
    public static int getDayOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 返回当前时间是周几 0是周日，
     *   1 2 3 4 5 6 7
     *   7 1 2 3 4 5 6
     * @return
     */
    public static int getDayOfWeek(){
        return cal.get(Calendar.DAY_OF_WEEK) - 1 == 0 ? 7 : cal.get(Calendar.DAY_OF_WEEK) - 1;
    }
    /**
     * 返回当前时间是周几 0是周日，
     * @return
     */
    public static int getDayOfWeek(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) - 1 == 0 ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }
    /**
     * 获取指定年月日是周几
     * @param year
     * @param month
     * @return
     */
    public static int getDayOfWeek(int year,int month,int day){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DATE, day);
        return calendar.get(Calendar.DATE);
    }

}
