package com.util;

import com.alibaba.fastjson.JSONObject;

public class JsonUtil {

    /**
     * 字符串转JSON
     * @param text
     * @return
     */
    public static JSONObject parseJSON(String text){
       return JSONObject.parseObject(text);
    }
    /**
     * 对象转json
     * @param object
     * @return
     */
    public static String josnToString(Object object){
        return JSONObject.toJSONString(object);
    }
}
