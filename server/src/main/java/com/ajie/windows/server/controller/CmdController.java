package com.ajie.windows.server.controller;

import com.ajie.windows.server.service.ControlService;
import com.ajie.windows.server.service.impl.MonitorService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 接受命令
 */
@RestController
@RequestMapping("/cmd")
@CrossOrigin
public class CmdController {
    @Resource
    private ControlService controlService;
    @Resource
    private MonitorService monitorService;

    /**
     * 驱动操作
     *
     * @param type  类型 ${@link ControlService} 常量
     * @param delay 延迟休眠时需要
     * @return
     */
    @GetMapping("driveIt")
    public String driveIt(@RequestParam("type") String type, @RequestParam(required = false, value = "delay") Integer delay) {
        ControlService.Handler handler = controlService.getHandler(type);
        if (null == handler) {
            return "false";
        }
        boolean apply = handler.apply();
        return String.valueOf(apply);
    }

    /**
     * 获取结果（消费者端调用）
     *
     * @return
     */
    @GetMapping("/get")
    public String get() {
        String s = monitorService.get();
        monitorService.clear();
        return s;
    }

}
