package com.ajie.windows.utils;

import com.ajie.windows.service.MonitorService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CmdUtil {

    public static final String SLEEP_CMD = "Shutdown /h";

    public static final Map<String, String> CMDS = new HashMap<>();

    static {
        CMDS.put(MonitorService.SLEEP, SLEEP_CMD);
    }

    /**
     * 执行windowns命令
     *
     * @param cmd
     * @return
     * @throws IOException
     */
    static public String execWindowsCmd(String cmd) throws IOException {
        if (null == cmd)
            return "";
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        Process proc = Runtime.getRuntime().exec("cmd /c " + cmd);
        reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    public static String getCmd(String type) {
        return CMDS.get(type);
    }
}
