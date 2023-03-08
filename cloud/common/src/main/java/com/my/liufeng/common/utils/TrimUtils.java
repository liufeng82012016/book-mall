package com.my.liufeng.common.utils;

/**
 * 仅提供字符串trim方法
 */
public class TrimUtils {
    public static String trim(String str){
        if (str == null){
            return null;
        }
        return str.trim();
    }
}
