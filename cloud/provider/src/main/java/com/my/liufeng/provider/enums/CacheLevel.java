package com.my.liufeng.provider.enums;

import java.time.Duration;

/**
 * 缓存重要性等级，等级越大，缓存时间越长
 */
public enum CacheLevel {
    /**
     * 常用分布式锁 5s
     */
    COMMON_LOCK(Duration.ofSeconds(5)),
    MIDDLE_LOCK(Duration.ofSeconds(30)),
    LARGE_LOCK(Duration.ofSeconds(60)),
    /**
     * 缓存
     */
    COMMON_CACHE(Duration.ofMinutes(5)),
    CACHE(Duration.ofHours(1)),
    /**
     * 后台管理系统token
     */
    ADMIN_TOKEN(Duration.ofMinutes(15)),
    /**
     * web网页token
     */
    WEB_TOKEN(Duration.ofHours(24)),
    /**
     * 近乎永久性的缓存
     */
    PERMANENT_CACHE(Duration.ofDays(365)),
    ;
    private final Duration duration;

    CacheLevel(Duration duration) {
        this.duration = duration;
    }

    public Duration getDuration() {
        return duration;
    }
}
