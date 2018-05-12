package com.util;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class JsonUtilTest {
    String objectStr="{\"name\":\"JSON\",\"age\":\"24\",\"address\":\"北京市西城区\"}";


    @Test
    public void parseJSON(){
        JSONObject jsonObject = JsonUtil.parseJSON(objectStr);
        System.out.println(jsonObject);
        System.out.println(jsonObject.get("address"));
    }
    @Test
    public void map(){
        Map map =new HashMap();
        map.put("name","zhi");
        map.put("tel","1234567");
        String string = JsonUtil.josnToString(map);
        System.out.println(string);
        JSONObject jsonObject = JsonUtil.parseJSON(string);
        System.out.println(jsonObject);
    }
}
