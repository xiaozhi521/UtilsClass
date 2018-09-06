package com.util;

import java.util.*;

public class StringUtil {
    /**
     * 判断一个对象是否为空；
     */
    public final static boolean isEmpty(Object o) {
        return (o == null);
    }

    /**
     * 检测某个字符变量是否为空；<br>
     * 为空的情况，包括：null，空串或只包含可以被 trim() 的字符；
     *  start
     */
    public final static boolean isEmpty(String value) {
        if (value == null || value.trim().length() == 0)
            return true;
        else
            return false;
    }

    public final static boolean isEmpty(String[] array) {
        if (array == null || array.length == 0)
            return true;
        else
            return false;
    }

    public final static boolean isEmpty(int[] array) {
        if (array == null || array.length == 0)
            return true;
        else
            return false;
    }

    public final static boolean isEmpty(StringBuffer sb) {
        if (sb == null || sb.length() == 0)
            return true;
        else
            return false;
    }

    public final static boolean isEmpty(List list) {
        if (list == null || list.size() == 0)
            return true;
        else
            return false;
    }

    public final static boolean isEmpty(Set set) {
        if (set == null || set.size() == 0)
            return true;
        else
            return false;
    }

    public final static boolean isEmpty(Map map) {
        if (map == null || map.size() == 0)
            return true;
        else
            return false;
    }
    //end
    /**
     * 生成一个随机数字；
     */
    public final static int getRandomNumber(int max) {
        return getRandomNumber(0, max);
    }

    public final static int getRandomNumber(int min, int max) {
        if (min > max) {
            int k = min;
            min = max;
            max = k;
        } else if (min == max) {
            return min;
        }
        Random random = new Random();
        return (random.nextInt(max - min) + min);
    }
    /**
     * 从指定的字符列表中生成随机字符串
     */
    public final static String getRandomString(int length) {
        final String[] s = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "D", "E", "F", "G", "H", "J", "L", "M", "N", "Q", "R", "T", "Y"};

        if (length < 1)
            return "";

        StringBuffer sb = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            int position = getRandomNumber(s.length - 1);
            Collections.shuffle(Arrays.asList(s));
            sb.append(s[position]);
        }

        return sb.toString();
    }
}
