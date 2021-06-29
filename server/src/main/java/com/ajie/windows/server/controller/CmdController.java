package com.ajie.windows.server.controller;

import com.ajie.windows.server.service.MonitorService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 接受命令
 */
@RestController
@RequestMapping("/cmd")
@CrossOrigin
public class CmdController {
    @Resource
    private MonitorService sleepMonitor;

    /**
     * 执行睡眠
     *
     * @return
     */
    @GetMapping("/sleep")
    public String execSleep() {
        boolean b = sleepMonitor.sleepOn();
        return String.valueOf(b);
    }

    /**
     * 静音/取消静音
     *
     * @return
     */
    @GetMapping("/toggle-slient")
    public String execSlientOff() {
        boolean b = sleepMonitor.toggleSlient();
        return String.valueOf(b);
    }

    /**
     * 关闭客户端
     *
     * @return
     */
    @GetMapping("/close-clients")
    public String closeClients() {
        boolean b = sleepMonitor.closeOn();
        return String.valueOf(b);
    }

    /**
     * 获取结果（消费者端调用）
     *
     * @return
     */
    @GetMapping("/get")
    public JSONObject get() {
        JSONObject obj = new JSONObject();
        obj.put("sleep", canSleep());
        obj.put("slient", getSlient());
        obj.put("close", canClose());
        return obj;
    }

    /**
     * 是否可睡眠
     *
     * @return
     */
    @GetMapping("/can-sleep")
    public boolean canSleep() {
        boolean canSleep = sleepMonitor.canSleep();
        if (canSleep) {
            //消费完后重置
            sleepMonitor.sleepOff();
        }
        return canSleep;
    }

    /**
     * 是否可睡眠
     *
     * @return
     */
    @GetMapping("/get-slient")
    public boolean getSlient() {
        boolean canSlient = sleepMonitor.getSlient();
        return canSlient;
    }

    /**
     * 是否关闭客户端
     *
     * @return
     */
    @GetMapping("/can-close")
    public boolean canClose() {
        boolean canClose = sleepMonitor.canClose();
        if (canClose) {
            //消费完了后重置
            sleepMonitor.closeOff();
        }
        return canClose;
    }

}
