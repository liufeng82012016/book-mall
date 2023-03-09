package com.my.liufeng.common.utils;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class JsonUtils {

    public static <T> T read(String jsonStr, Class<T> type) {
        return JSON.parseObject(jsonStr, type);
    }

    public static <T> List<T> readArray(String jsonStr, Class<T> type) {
        return JSON.parseArray(jsonStr, type);
    }

    /**
     * 将指定对象转为json字符串
     */
    public static String toJsonString(Object obj) {
        return JSON.toJSONString(obj);
    }
}
