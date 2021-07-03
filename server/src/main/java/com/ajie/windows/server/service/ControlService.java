package com.ajie.windows.server.service;

/**
 * 控制服务
 */
public interface ControlService {
    /**
     * 静音/取消静音
     */
    static final String SILENT_TOGGLE = "silentToggle";
    /**
     * 音量减
     */
    static final String DECR = "decr";
    /**
     * 音量加
     */
    static final String INCR = "incr";
    /**
     * 切换活动窗口
     */
    static final String TAB = "tab";
    /**
     * 关闭当前活动窗口
     */
    static final String CLOSE_TAB = "closeTab";
    /**
     * 断开客户单连接
     */
    static final String CLOSE_CLIENT = "closeClient";
    /**
     * 睡眠
     */
    static final String SLEEP = "sleep";

    /**
     * 重启
     */
    static final String REBOOT = "reboot";

    /**
     * 关机
     */
    static final String SHUTDOWN = "shutdown";

    /**
     * 延迟休眠
     */
    static final String DELAY_SLEEP = "delaySleep";


    boolean register(String type, Handler handler);

    Handler getHandler(String type);

    interface Handler {
        boolean rgister();

        boolean apply();
    }
}
