package com.util.file;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileUtil {
    //网络路径获取文件流
    public static InputStream getInputStream(String urlPath) throws IOException {
        URL url = new URL(urlPath);
        HttpURLConnection uc = (HttpURLConnection) url.openConnection();
        uc.setDoInput(true);//设置是否要从 URL 连接读取数据,默认为true
        uc.connect();
        return uc.getInputStream();
    }
}
