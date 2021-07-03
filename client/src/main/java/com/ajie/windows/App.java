package com.ajie.windows;

import com.ajie.windows.service.Monitor;

public class App {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        monitor.startTask();
    }
}
