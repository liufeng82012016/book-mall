package com.my.liufeng.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.liufeng.common.enums.ErrorCode;
import com.my.liufeng.common.exception.BrokenException;
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
            throw new BrokenException(ErrorCode.DATA_ERROR);
        }
    }

    public static <T> T read(String jsonStr, Class<T> type) {
        try {
            return objectMapper.readValue(jsonStr, type);
        } catch (JsonProcessingException e) {
            throw new BrokenException(ErrorCode.DATA_ERROR);
        }
    }

    /**
     * 将指定对象转为json字符串
     */
    public static String toJsonString(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new BrokenException(ErrorCode.DATA_ERROR);
        }
    }
}
