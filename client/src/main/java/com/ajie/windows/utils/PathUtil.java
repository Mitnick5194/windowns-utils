package com.ajie.windows.utils;

import com.ajie.windows.App;

public class PathUtil {

    public static String getClassPath() {
        return PathUtil.class.getResource("/").getPath();
    }
}
