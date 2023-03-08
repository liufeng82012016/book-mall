package com.my.liufeng.common;

import com.my.liufeng.common.enums.ErrorCode;
import com.my.liufeng.common.exception.BrokenException;

import java.util.Collection;
import java.util.Map;

/**
 * 简单断言工具类
 */
public class Asserts {
    /**
     * 期望表达式结果为true
     *
     * @param expression 表达式
     * @param error      错误码
     */
    public static void assertTrue(Boolean expression, ErrorCode error) {
        if (!Boolean.TRUE.equals(expression)) {
            throw new BrokenException(error);
        }
    }

    /**
     * 期望表达式结果为false
     *
     * @param expression 表达式
     * @param error      错误码
     */
    public static void assertFalse(Boolean expression, ErrorCode error) {
        if (!Boolean.FALSE.equals(expression)) {
            throw new BrokenException(error);
        }
    }

    /**
     * 期望对象非空
     *
     * @param obj   对象
     * @param error 错误码
     */
    public static void assertNotNull(Object obj, ErrorCode error) {
        if (obj == null) {
            throw new BrokenException(error);
        }
    }

    /**
     * 期望字符串非空
     *
     * @param str   字符串
     * @param error 错误码
     */
    public static void assertNotEmpty(String str, ErrorCode error) {
        if (str == null || str.trim().length() < 1) {
            throw new BrokenException(error);
        }
    }

    /**
     * 期望集合非空
     *
     * @param collection 集合
     * @param error      错误码
     */
    public static void assertNotEmpty(Collection<?> collection, ErrorCode error) {
        if (collection == null || collection.isEmpty()) {
            throw new BrokenException(error);
        }
    }

    /**
     * 期望map非空
     *
     * @param map   map
     * @param error 错误码
     */
    public static void assertNotEmpty(Map<?, ?> map, ErrorCode error) {
        if (map == null || map.isEmpty()) {
            throw new BrokenException(error);
        }
    }

    /**
     * 期望指定数据为正(这里只判断整数)
     *
     * @param number 数字
     */
    public static void assertPositive(Number number, ErrorCode error) {
        if (number == null) {
            return;
        }
        Asserts.assertTrue(number.longValue() > 0, error);
    }
}
