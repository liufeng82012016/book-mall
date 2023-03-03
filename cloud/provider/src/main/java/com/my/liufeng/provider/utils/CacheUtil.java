package com.my.liufeng.provider.utils;

import com.my.liufeng.provider.enums.CacheLevel;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * 自定义分布式缓存工具类
 */
public class CacheUtil {

    public static void set(String key, Object value) {
        set(key, value, CacheLevel.PERMANENT_CACHE.getDuration());
    }

    public static void set(String key, Object value, int time, TimeUnit timeUnit) {
        SpringUtil.redisTemplate().opsForValue().set(key, value, time, timeUnit);
    }

    public static void set(String key, Object value, Duration duration) {
        SpringUtil.redisTemplate().opsForValue().set(key, value, duration.getSeconds(), TimeUnit.SECONDS);
    }

    public static void set(String key, Object value, CacheLevel cacheLevel) {
        SpringUtil.redisTemplate().opsForValue().set(key, value, cacheLevel.getDuration().getSeconds(), TimeUnit.SECONDS);
    }

    public static Object get(String key) {
        return SpringUtil.redisTemplate().opsForValue().get(key);
    }

    public static <T> T get(String key,Class<T> clazz) {
        return (T) SpringUtil.redisTemplate().opsForValue().get(key);
    }
}
