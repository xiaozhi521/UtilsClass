package com.util;

import org.junit.Test;


public class Base64UtilTest {


    @Test
    public void base64Transformation(){
        String string = Base64Util.GetImageStrFromPath("E:\\我的照片\\IMG_0650(0).JPG");
        System.out.println(string);
        System.out.println("================");

        if(Base64Util.GenerateImage(string,"C:\\Users\\HP\\Desktop\\a.png")){
            System.out.println("编码生成图片成功");
        }else{
            System.out.println("编码生成图片失败");
        }

    }
}
