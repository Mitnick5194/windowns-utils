package com.ajie.windows.server.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 睡眠监控器
 */
@Service
public class MonitorService {
    private static AtomicBoolean sleepMonitor = new AtomicBoolean(false);
    private static AtomicBoolean slientMonitor = new AtomicBoolean(false);
    private static AtomicBoolean closeMonitor = new AtomicBoolean(false);

    public boolean sleepOn() {
        return sleepMonitor.compareAndSet(false, true);
    }

    public boolean sleepOff() {
        return sleepMonitor.compareAndSet(true, false);
    }

  /*  public boolean slientOn() {
        return slientMonitor.compareAndSet(false, true);
    }*/

    public boolean toggleSlient() {
        slientMonitor.set(!slientMonitor.get());
        return true;
    }

    public boolean closeOn() {
        return closeMonitor.compareAndSet(false, true);
    }

    public boolean closeOff() {
        return closeMonitor.compareAndSet(true, false);
    }

    /*一下api提供给消费端使用*/
    public boolean canSleep() {
        return sleepMonitor.get();
    }

    public boolean getSlient() {
        return slientMonitor.get();
    }

    public boolean canClose() {
        return closeMonitor.get();
    }


}
