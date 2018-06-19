package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 读取配置文件
 */
public class ReadPropertiesUtil {
    public static String ADMIN;
    public static String PWD;

    static {
        Properties properties = new Properties();
        String path = ReadPropertiesUtil.class.getResource("/").getFile().toString()
                + "admin.properties";
        try {
            FileInputStream fis = new FileInputStream(new File(path));
            properties.load(fis);
            ADMIN = properties.getProperty("ADMIN");
            PWD = properties.getProperty("PWD");
        } catch (Exception e) {
            BugUtil.addBug(e);
        }
    }
}
