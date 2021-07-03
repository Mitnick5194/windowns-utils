package com.ajie.windows.utils;

/**
 * windows休眠工具
 */
public class MonitorUtil {
   /* private static String PROPERTIES_FILE_PATH = "N:\\daily\\win-utils\\properties.properties";

    static {
        String properties = System.getProperty("properties");
        if (null != properties) {
            PROPERTIES_FILE_PATH = properties;
        }
    }

    public static void sleep() {
        String cmd = "Shutdown /h";
        try {
            CmdUtil.execWindowsCmd(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    *//**
     * 静音与取消静音切换
     *//*
    public static void toggleSlient() {
        String cmd = getSlientBat();
        try {
            CmdUtil.execWindowsCmd(cmd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    *//**
     * 获取静音文件
     *
     * @return
     *//*
    private static String getSlientBat() {
        String classPath = PathUtil.getClassPath();
        //去除前面的"/"
        classPath = classPath.substring(1);
        //return classPath + "slient.bat";
        // return "M:\\_idea_ws\\windows-utils\\client\\target\\classes\\slient.bat";
        return Monitor.prop.getSlientBatPath();
    }
*/

}
