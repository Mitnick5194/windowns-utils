package com.ajie.windows.service;

import com.ajie.windows.utils.CmdUtil;
import com.ajie.windows.utils.VbsUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 睡眠监控器
 * <p>断开客户端连接，关机、重启、休眠属于高优先级，遇到该操作，后面的就不用往下执行了</p>
 */
public class MonitorService {

    /**
     * 静音/取消静音
     */
    public static final String SILENT_TOGGLE = "silentToggle";
    /**
     * 音量减
     */
    public static final String DECR = "decr";
    /**
     * 音量加
     */
    public static final String INCR = "incr";
    /**
     * 切换活动窗口
     */
    public static final String TAB = "tab";
    /**
     * 关闭当前活动窗口
     */
    public static final String CLOSE_TAB = "closeTab";
    /**
     * 断开客户单连接
     */
    public static final String CLOSE_CLIENT = "closeClient";
    /**
     * 睡眠
     */
    public static final String SLEEP = "sleep";

    /**
     * 重启
     */
    public static final String REBOOT = "reboot";

    /**
     * 关机
     */
    public static final String SHUTDOWN = "shutdown";

    /**
     * 延迟休眠
     */
    public static final String DELAY_SLEEP = "delaySleep";

    /**
     * 睡眠监控
     */
    private AtomicBoolean sleepMonitor = new AtomicBoolean(false);

    /**
     * 关机监控
     */
    private AtomicBoolean shutdownMonitor = new AtomicBoolean(false);

    /**
     * 重启监控
     */
    private AtomicBoolean rebootMonitor = new AtomicBoolean(false);

    /**
     * 延迟睡眠监控
     */
    private AtomicBoolean delaySleepMonitor = new AtomicBoolean(false);

    /**
     * 静音/取消静音
     */
    private AtomicBoolean silentToggleMonitor = new AtomicBoolean(false);

    /**
     * 减少音量
     */
    private AtomicBoolean decrMonitor = new AtomicBoolean(false);
    /**
     * 增加音量
     */
    private AtomicBoolean incrMonitor = new AtomicBoolean(false);

    /**
     * 断开客户端连接
     */
    private AtomicBoolean closeClientMonitor = new AtomicBoolean(false);

    /**
     * 切换活动窗口
     */
    private AtomicBoolean tabMonitor = new AtomicBoolean(false);

    /**
     * 关闭当前活动窗口
     */
    private AtomicBoolean closeTabMonitor = new AtomicBoolean(false);

    public void driveIt() {
        List<String> parse = parse();
        for (String type : parse) {
            String cmd = VbsUtil.getVbsCmd(type);
            if (null == cmd) {
                cmd = CmdUtil.getCmd(type);
            }
            if (null == cmd && CLOSE_CLIENT.equals(type)) {
                //断开客户端
                System.out.println("断开客户端");
                System.exit(0);
                return;
            }
            if (null == cmd) {
                System.out.println("未知命令：" + cmd);
                return;
            }
            try {
                CmdUtil.execWindowsCmd(cmd);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<String> parse() {
        List<String> result = new ArrayList<>();
        if (closeClientMonitor.get()) {
            add(result, CLOSE_CLIENT); //高优先级，后面的就不用执行了
            return result;
        }
        if (shutdownMonitor.get()) {
            result.add(SHUTDOWN);
            return result;//高优先级，后面的就不用执行了
        }
        if (rebootMonitor.get()) {
            result.add(REBOOT);
            return result;//高优先级，后面的就不用执行了
        }
        if (sleepMonitor.get()) {
            result.add(SLEEP);
            return result;//高优先级，后面的就不用执行了
        }
        if (silentToggleMonitor.get()) {
            result.add(SILENT_TOGGLE);
        }
        if (incrMonitor.get()) {
            result.add(INCR);
        }
        if (decrMonitor.get()) {
            add(result, DECR);
        }
        if (tabMonitor.get()) {
            add(result, TAB);
        }
        if (closeTabMonitor.get()) {
            add(result, CLOSE_TAB);
        }
        if (delaySleepMonitor.get()) {
            add(result, DELAY_SLEEP);
        }
        return result;
    }

    private void add(List<String> list, String value) {
        list.add(value);
    }

    public AtomicBoolean getRebootMonitor() {
        return rebootMonitor;
    }

    public void setRebootMonitor(AtomicBoolean rebootMonitor) {
        this.rebootMonitor = rebootMonitor;
    }

    public AtomicBoolean getDelaySleepMonitor() {
        return delaySleepMonitor;
    }

    public void setDelaySleepMonitor(AtomicBoolean delaySleepMonitor) {
        this.delaySleepMonitor = delaySleepMonitor;
    }

    public AtomicBoolean getSilentToggleMonitor() {
        return silentToggleMonitor;
    }

    public void setSilentToggleMonitor(AtomicBoolean silentToggleMonitor) {
        this.silentToggleMonitor = silentToggleMonitor;
    }

    public AtomicBoolean getDecrMonitor() {
        return decrMonitor;
    }

    public void setDecrMonitor(AtomicBoolean decrMonitor) {
        this.decrMonitor = decrMonitor;
    }

    public AtomicBoolean getIncrMonitor() {
        return incrMonitor;
    }

    public void setIncrMonitor(AtomicBoolean incrMonitor) {
        this.incrMonitor = incrMonitor;
    }

    public AtomicBoolean getCloseClientMonitor() {
        return closeClientMonitor;
    }

    public void setCloseClientMonitor(AtomicBoolean closeClientMonitor) {
        this.closeClientMonitor = closeClientMonitor;
    }

    public AtomicBoolean getTabMonitor() {
        return tabMonitor;
    }

    public void setTabMonitor(AtomicBoolean tabMonitor) {
        this.tabMonitor = tabMonitor;
    }

    public AtomicBoolean getCloseTabMonitor() {
        return closeTabMonitor;
    }

    public void setCloseTabMonitor(AtomicBoolean closeTabMonitor) {
        this.closeTabMonitor = closeTabMonitor;
    }

    public AtomicBoolean getSleepMonitor() {
        return sleepMonitor;
    }

    public void setSleepMonitor(AtomicBoolean sleepMonitor) {
        this.sleepMonitor = sleepMonitor;
    }

    public AtomicBoolean getShutdownMonitor() {
        return shutdownMonitor;
    }

    public void setShutdownMonitor(AtomicBoolean shutdownMonitor) {
        this.shutdownMonitor = shutdownMonitor;
    }
}
