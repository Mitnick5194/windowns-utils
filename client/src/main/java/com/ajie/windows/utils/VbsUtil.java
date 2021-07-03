package com.ajie.windows.utils;

import com.ajie.windows.service.Monitor;
import com.ajie.windows.service.MonitorService;

import java.util.HashMap;
import java.util.Map;

/**
 * vbs工具
 */
public class VbsUtil {
    /**
     * 使用vbs执行的命令
     */
    private static final Map<String, String> VBS_CMD = new HashMap<>();

    static {
        VBS_CMD.put(MonitorService.CLOSE_TAB, MonitorService.CLOSE_TAB);
        VBS_CMD.put(MonitorService.SILENT_TOGGLE, MonitorService.SILENT_TOGGLE);
        VBS_CMD.put(MonitorService.DECR, MonitorService.DECR);
        VBS_CMD.put(MonitorService.INCR, MonitorService.INCR);
        VBS_CMD.put(MonitorService.TAB, MonitorService.TAB);
        VBS_CMD.put(MonitorService.CLOSE_TAB, MonitorService.CLOSE_TAB);
    }

    public static String getVbsCmd(String type) {
        String option = VBS_CMD.get(type);
        if (null == option || option.trim().length() == 0) {
            return null;
        }
        Monitor.Prop prop = Monitor.prop;
        String controlVbsPath = prop.getControlVbsPath();
        return controlVbsPath + " " + option;
    }
}
