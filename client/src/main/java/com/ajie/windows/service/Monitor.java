package com.ajie.windows.service;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import com.ajie.windows.utils.PathUtil;

import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

public class Monitor {
    //private static final long delay = 3 * 1000;
    //private static final String url = "http://localhost:54321/cmd/get";
    //private static final AtomicBoolean slientFlag = new AtomicBoolean(false);
    public static final Prop prop;

    static {
        prop = new Prop();
    }

    public void startTask() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MonitorTimerTask(), prop.getInterval(), prop.getInterval());
    }

    class MonitorTimerTask extends TimerTask {

        @Override
        public void run() {
            try {
                String result = HttpUtil.get(prop.getUrl());
                if (null == result || result.length() == 0) {
                    return;
                }
                JSONObject json = new JSONObject(result);
                MonitorService monitorService = json.toBean(MonitorService.class);
                monitorService.driveIt();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static class Prop {
        private Properties properties;

        private String url;
        //执行间隔，单位毫秒
        private long interval;
        //静音脚本路径
        private String controlVbsPath;

        public Prop() {
            properties = PathUtil.loadProperties();
            init();
        }

        public void init() {
            String url = properties.getProperty("url", "");
            String controlVbsPath = properties.getProperty("control_vbs_path", "");
            //配置文件里的单位是秒
            String interval = properties.getProperty("interval", "0");
            this.url = url;
            this.controlVbsPath = controlVbsPath;
            this.interval = Long.valueOf(interval) * 1000;
        }

        public String getUrl() {
            return url;
        }

        public String getControlVbsPath() {
            return controlVbsPath;
        }

        public long getInterval() {
            return interval;
        }

    }
}
