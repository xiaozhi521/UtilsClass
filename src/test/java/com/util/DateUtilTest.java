package com.util;

import org.junit.Test;

public class DateUtilTest {
    @Test
    public void getTimeMillis(){
        System.out.println(DateUtil.getTimeMillis("2016-03-10 07:18:39.763"));
    }
    //测试时间戳转日期
    @Test
    public void getFormatDate1(){
        System.out.println(DateUtil.getFormatDate(System.currentTimeMillis()));
    }
    @Test
    public void getFormatDate(){
        System.out.println(DateUtil.getFormatDate());
    }
    @Test
    public void getCurrentDate(){
        System.out.println(DateUtil.getCurrentDate());
    }


}
