package com.ajie.windows;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;

import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class Monitor {
    //private static final long delay = 3 * 1000;
    //private static final String url = "http://localhost:54321/cmd/get";
    private static final AtomicBoolean slientFlag = new AtomicBoolean(false);
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
                //休眠操作
                boolean sleep = json.getBool("sleep");
                //静音操作
                boolean slient = json.getBool("slient");
                //关闭客户端
                boolean close = json.getBool("close");
                if (close) {
                    System.exit(0);
                    return;
                }
                if (sleep) {
                    MonitorUtil.sleep();
                    return;//如果是休眠的話，沒必要往下执行了
                }
                //只有当slientFlag与slient对立时，才进行静音/取消静音操作
                boolean flag = slientFlag.compareAndSet(!slient, slient);
                if (!flag) {
                    return;
                }
                MonitorUtil.toggleSlient();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    static class Prop {
        private Properties properties;

        private String url;
        //执行间隔，单位毫秒
        private long interval;
        //静音脚本路径
        private String slientBatPath;

        public Prop() {
            properties = MonitorUtil.loadProperties();
            init();
        }

        public void init() {
            String url = properties.getProperty("url", "");
            String slientBatPath = properties.getProperty("slient_bat_path", "");
            //配置文件里的单位是秒
            String interval = properties.getProperty("interval", "0");
            this.url = url;
            this.slientBatPath = slientBatPath;
            this.interval = Long.valueOf(interval) * 1000;
        }

        public String getUrl() {
            return url;
        }

        public String getSlientBatPath() {
            return slientBatPath;
        }

        public long getInterval() {
            return interval;
        }

    }
}
