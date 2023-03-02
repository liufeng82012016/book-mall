package com.my.liufeng.gateway.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 读取json文件为指定对象
     *
     * @param jsonStr json字符串
     */
    public static <T> T read(String jsonStr, TypeReference<T> type) {
        try {
            return objectMapper.readValue(jsonStr, type);
        } catch (JsonProcessingException e) {
            log.info("parse json fail.str:{}", jsonStr, e);
            return null;
        }
    }

    /**
     * 将指定对象转为json字符串
     */
    public static String toJsonString(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.info("parse json fail.obj:{}", obj, e);
        }
        return null;
    }
}
