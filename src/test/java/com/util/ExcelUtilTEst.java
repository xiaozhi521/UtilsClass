package com.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bean.Person;
import com.util.excel.ExcelReadUtil;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

public class ExcelUtilTEst {
    @Test
    public void readExcel(){
        ArrayList list =  ExcelReadUtil.readExcel(new File("E:\\idea\\UtilsClass\\src\\main\\testfile\\test.xls"));
        System.out.println(list);
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        Person person = null;
        for(int i = 0; i < list.size(); i++){
            ArrayList list1 = (ArrayList) list.get(i);
//            System.out.println(list1.get(0));
            person = new Person();
            person.setName((String) list1.get(0));
            person.setSex((String) list1.get(1));
            person.setEducation((String) list1.get(3));
            person.setAddress((String) list1.get(2));
            jsonArray.add(person);
//            System.out.println(person.toString());
        }
        System.out.println(jsonArray.toJSONString());
    }
}
