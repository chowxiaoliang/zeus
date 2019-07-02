package com.zl.loader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadResources {

    public static void main(String[] args) throws IOException {

        LoadResources loaderOne = new LoadResources();
        Properties properties = new Properties();
//        InputStream inputStream = LoadResources.class.getResourceAsStream("/application.properties");
        InputStream inputStream = loaderOne.getClass().getResourceAsStream("/application.properties");
//        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
        properties.load(inputStream);
        System.out.println(properties.getProperty("multipart.maxFileSize"));
    }
}
