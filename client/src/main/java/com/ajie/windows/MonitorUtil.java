package com.ajie.windows;

import com.ajie.windows.utils.CmdUtil;
import com.ajie.windows.utils.PathUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * windows休眠工具
 */
public class MonitorUtil {
    private static final String PROPERTIES_FILE_PATH = "N:\\daily\\win-utils\\properties.properties";

    public static void sleep() {
        String cmd = "Shutdown /h";
        try {
            CmdUtil.execWindowsCmd(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 静音与取消静音切换
     */
    public static void toggleSlient() {
        String cmd = getSlientBat();
        try {
            CmdUtil.execWindowsCmd(cmd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取静音文件
     *
     * @return
     */
    private static String getSlientBat() {
        String classPath = PathUtil.getClassPath();
        //去除前面的"/"
        classPath = classPath.substring(1);
        //return classPath + "slient.bat";
        // return "M:\\_idea_ws\\windows-utils\\client\\target\\classes\\slient.bat";
        return Monitor.prop.getSlientBatPath();
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
