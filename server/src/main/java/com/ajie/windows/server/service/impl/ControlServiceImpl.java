package com.ajie.windows.server.service.impl;

import com.ajie.windows.server.service.ControlService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class ControlServiceImpl implements ControlService {
    private ConcurrentHashMap<String, Handler> handlers;

    public ControlServiceImpl() {
        handlers = new ConcurrentHashMap<>(8);
    }

    @Override
    public boolean register(String type, Handler handler) {
        return null == handlers.put(type, handler);
    }

    @Override
    public Handler getHandler(String type) {
        return handlers.get(type);
    }
}
