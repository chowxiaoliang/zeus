package com.zl.loader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 利用类加载器加载资源文件
 * InputStream inputStream = LoadResources.class.getResourceAsStream("/application.properties");
 * InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
 * 注意有/和没有/的区别
 */
public class LoadResources {

    public static void main(String[] args) throws IOException {

        LoadResources loaderOne = new LoadResources();
        Properties properties = new Properties();
        InputStream inputStream = loaderOne.getClass().getResourceAsStream("/application.properties");
        properties.load(inputStream);
        System.out.println(properties.getProperty("multipart.maxFileSize"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
