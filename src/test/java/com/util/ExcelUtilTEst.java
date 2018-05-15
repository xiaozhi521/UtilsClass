package com.util;

import com.bean.Person;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

public class ExcelUtilTEst {
    @Test
    public void readExcel(){
        ArrayList list =  ExcelUtil.readExcel(new File("E:\\idea\\UtilsClass\\src\\main\\testfile\\test.xls"));
        System.out.println(list);
        for(int i = 0; i < list.size(); i++){
            ArrayList list1 = (ArrayList) list.get(i);
//            System.out.println(list1.get(0));
            Person person = new Person();
            person.setName((String) list1.get(0));
            person.setSex((String) list1.get(1));
            person.setEducation((String) list1.get(3));
            person.setAddress((String) list1.get(2));
            System.out.println(person.toString());
        }
    }
}
