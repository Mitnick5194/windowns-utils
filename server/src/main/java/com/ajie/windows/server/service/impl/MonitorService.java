package com.ajie.windows.server.service.impl;

import com.ajie.windows.server.service.ControlService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 睡眠监控器
 */
@Service
public class MonitorService {

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

    /**
     * 睡眠
     */
    public boolean sleep() {
        return sleepMonitor.compareAndSet(false, true);
    }

    /**
     * 关机
     */
    public boolean shutdown() {
        return shutdownMonitor.compareAndSet(false, true);
    }

    /**
     * 重启
     */
    public boolean reboot() {
        return rebootMonitor.compareAndSet(false, true);
    }

    /**
     * 延迟睡眠
     */
    public boolean delaySleep() {
        return delaySleepMonitor.compareAndSet(false, true);
    }

    /**
     * 静音/取消静音
     */
    public boolean silentToggleMonitor() {
        return silentToggleMonitor.compareAndSet(false, true);
    }

    /**
     * 音量-
     */
    public boolean decr() {
        return decrMonitor.compareAndSet(false, true);
    }

    /**
     * 音量+
     */
    public boolean incr() {
        return incrMonitor.compareAndSet(false, true);
    }

    /**
     * 关闭客户端连接
     */
    public boolean closeClient() {
        return closeClientMonitor.compareAndSet(false, true);
    }

    /**
     * 切换活动窗口
     */
    public boolean tab() {
        return tabMonitor.compareAndSet(false, true);
    }

    /**
     * 关闭活动窗口
     */
    public boolean closeTab() {
        return closeTabMonitor.compareAndSet(false, true);
    }


    /**
     * 获取结果
     *
     * @return json字串
     */
    public String get() {
        return JSONObject.toJSONString(this);
    }

    /**
     * 清除所有的标识
     */
    public void clear() {
        sleepMonitor.set(false);
        shutdownMonitor.set(false);
        rebootMonitor.set(false);
        delaySleepMonitor.set(false);
        silentToggleMonitor.set(false);
        decrMonitor.set(false);
        incrMonitor.set(false);
        closeClientMonitor.set(false);
        tabMonitor.set(false);
        //为什么用这个api呢，因为用set的话idea会检测到大量代码重复而报警，不喜欢看到那堆黄线
        closeTabMonitor.compareAndSet(true, false);
    }

    public void clearByType(String type) {
        switch (type) {
            case ControlService.SILENT_TOGGLE:
                silentToggleMonitor.set(false);
                break;
            case ControlService.DECR:
                silentToggleMonitor.set(false);
                break;
            case ControlService.INCR:
                silentToggleMonitor.set(false);
                break;
            case ControlService.TAB:
                silentToggleMonitor.set(false);
                break;
            case ControlService.CLOSE_TAB:
                silentToggleMonitor.set(false);
                break;
            case ControlService.CLOSE_CLIENT:
                silentToggleMonitor.set(false);
                break;
            case ControlService.SLEEP:
                silentToggleMonitor.set(false);
                break;
            case ControlService.REBOOT:
                silentToggleMonitor.set(false);
                break;
            case ControlService.SHUTDOWN:
                silentToggleMonitor.set(false);
                break;
            case ControlService.DELAY_SLEEP:
                silentToggleMonitor.set(false);
                break;
            default:
                clear();
                break;
        }
    }


    public AtomicBoolean getSleepMonitor() {
        return sleepMonitor;
    }

    public void setSleepMonitor(AtomicBoolean sleepMonitor) {
        this.sleepMonitor = sleepMonitor;
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

    public AtomicBoolean getShutdownMonitor() {
        return shutdownMonitor;
    }

    public void setShutdownMonitor(AtomicBoolean shutdownMonitor) {
        this.shutdownMonitor = shutdownMonitor;
    }
}
