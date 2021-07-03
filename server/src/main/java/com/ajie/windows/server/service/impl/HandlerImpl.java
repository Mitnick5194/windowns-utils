package com.ajie.windows.server.service.impl;

import com.ajie.windows.server.service.ControlService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Service
public class HandlerImpl {
    @Resource
    private ControlServiceImpl service;
    @Resource
    private MonitorService monitorService;


    /**
     * 静音/取消静音处理器
     */
    @Service
    class SilentToggleHandler implements ControlService.Handler {

        @PostConstruct
        @Override
        public boolean rgister() {
            return service.register(ControlService.SILENT_TOGGLE, this);
        }

        @Override
        public boolean apply() {
            return monitorService.silentToggleMonitor();
        }
    }

    /**
     * 增大音量处理器
     */
    @Service
    class IncrHandler implements ControlService.Handler {

        @PostConstruct
        @Override
        public boolean rgister() {
            return service.register(ControlService.INCR, this);
        }

        @Override
        public boolean apply() {
            return monitorService.incr();
        }
    }

    /**
     * 减小音量处理器
     */
    @Service
    class DecrHandler implements ControlService.Handler {

        @PostConstruct
        @Override
        public boolean rgister() {
            return service.register(ControlService.DECR, this);
        }

        @Override
        public boolean apply() {
            return monitorService.decr();
        }
    }

    /**
     * 切换窗口处理器
     */
    @Service
    class TabHandler implements ControlService.Handler {

        @PostConstruct
        @Override
        public boolean rgister() {
            return service.register(ControlService.TAB, this);
        }

        @Override
        public boolean apply() {
            return monitorService.tab();
        }
    }

    /**
     * 关闭当前活动窗口处理器
     */
    @Service
    class CloseTabHandler implements ControlService.Handler {

        @PostConstruct
        @Override
        public boolean rgister() {
            return service.register(ControlService.CLOSE_TAB, this);
        }

        @Override
        public boolean apply() {
            return monitorService.closeTab();
        }
    }

    /**
     * 断开客户端连接处理器
     */
    @Service
    class CloseClientHandler implements ControlService.Handler {

        @PostConstruct
        @Override
        public boolean rgister() {
            return service.register(ControlService.CLOSE_CLIENT, this);
        }

        @Override
        public boolean apply() {
            return monitorService.closeClient();
        }
    }

    /**
     * 睡眠处理器
     */
    @Service
    class SleepHandler implements ControlService.Handler {

        @PostConstruct
        @Override
        public boolean rgister() {
            return service.register(ControlService.SLEEP, this);
        }

        @Override
        public boolean apply() {
            return monitorService.sleep();
        }
    }

    /**
     * 重启处理器
     */
    @Service
    class RebootHandler implements ControlService.Handler {

        @PostConstruct
        @Override
        public boolean rgister() {
            return service.register(ControlService.REBOOT, this);
        }

        @Override
        public boolean apply() {
            return monitorService.reboot();
        }
    }

    /**
     * 关机处理器
     */
    @Service
    class ShutdownHandler implements ControlService.Handler {

        @PostConstruct
        @Override
        public boolean rgister() {
            return service.register(ControlService.SHUTDOWN, this);
        }

        @Override
        public boolean apply() {
            return monitorService.shutdown();
        }
    }

    /**
     * 延迟休眠处理器
     */
    @Service
    class DelaySleepHandler implements ControlService.Handler {

        @PostConstruct
        @Override
        public boolean rgister() {
            return service.register(ControlService.DELAY_SLEEP, this);
        }

        @Override
        public boolean apply() {
            return monitorService.delaySleep();
        }
    }
}
