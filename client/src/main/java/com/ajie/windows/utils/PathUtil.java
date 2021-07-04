package com.ajie.windows.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PathUtil {
    private static String PROPERTIES_FILE_PATH = "N:\\daily\\win-utils\\properties.properties";

    static {
        String properties = System.getProperty("properties");
        if (null != properties && properties.trim().length() > 0) {
            PROPERTIES_FILE_PATH = properties;
        }
    }

    public static String getClassPath() {
        return PathUtil.class.getResource("/").getPath();
    }

    /**
     * 加载配置
     *
     * @return
     */
    public static Properties loadProperties() {
        Properties properties = new Properties();
        try {
            InputStream is = new FileInputStream(new File(PROPERTIES_FILE_PATH));
            properties.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}
