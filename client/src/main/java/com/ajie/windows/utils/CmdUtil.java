package com.ajie.windows.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdUtil {

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
}
