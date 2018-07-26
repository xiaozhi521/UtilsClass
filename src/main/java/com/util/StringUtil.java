package com.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
}
