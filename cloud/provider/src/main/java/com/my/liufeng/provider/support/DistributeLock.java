package com.my.liufeng.provider.support;

import com.my.liufeng.common.enums.ErrorCode;

public interface DistributeLock {

//    /**
//     * 生成分布式锁（自动延长）
//     *
//     * @param key key
//     * @return 分布式锁对象
//     */
//    DistributeLock getLock(String key);
//
//    /**
//     * 生成分布式锁
//     *
//     * @param key           key
//     * @param expireSeconds 过期时间(秒)
//     * @return 分布式锁对象
//     */
//    DistributeLock getLock(String key, long expireSeconds);
//
//    /**
//     * 生成分布式锁（自动延长）
//     *
//     * @param key           key
//     * @param maxRetryTimes 最大获取锁次数
//     * @param maxWaitMills  获取所最长等待时间（毫秒）
//     * @return 分布式锁对象
//     */
//    DistributeLock getLock(String key, int maxRetryTimes, int maxWaitMills);
//
//    /**
//     * 生成分布式锁
//     *
//     * @param key           key
//     * @param maxRetryTimes 最大获取锁次数
//     * @param maxWaitMills  获取所最长等待时间（毫秒）
//     * @param expireSeconds 过期时间(秒)
//     * @return 分布式锁对象
//     */
//    DistributeLock getLock(String key, int maxRetryTimes, int maxWaitMills, long expireSeconds);

    /**
     * 尝试加锁
     *
     * @return 是否加锁成功
     */
    boolean tryLock();

    /**
     * 尝试加锁，加锁失败抛出异常
     * @throws com.my.liufeng.common.exception.BrokenException
     */
    void lock();

    /**
     * 尝试加锁，加锁失败抛出异常
     *
     * @param errorCode 错误码
     */
    void lock(ErrorCode errorCode);


    /**
     * 释放锁
     */
    void unlock();


}
