package com.my.liufeng.provider.utils;

import com.my.liufeng.provider.support.DistributeLock;
import com.my.liufeng.provider.support.RedissionDistributeLock;
import lombok.extern.slf4j.Slf4j;

/**
 * 自定义分布式锁工具类
 */
@Slf4j
public class LockUtil {


//    /**
//     * 加锁
//     *
//     * @param key           key
//     * @param value         value
//     * @param expireSeconds 过期时间（秒）
//     * @return 是否加锁成功
//     */
//    public static boolean lock(String key, String value, int expireSeconds) {
//        return Boolean.TRUE.equals(SpringUtil.redisTemplate().opsForValue().setIfAbsent(key, value, expireSeconds, TimeUnit.SECONDS));
//    }
//
//    /**
//     * 期望加锁成功，否则抛出异常
//     */
//    public static void lockSuccess(String key, String value, int expireSeconds) {
//        boolean lock = lock(key, value, expireSeconds);
//        Object value2 = SpringUtil.redisTemplate().opsForValue().get(key);
//        if (log.isDebugEnabled()) {
//            log.debug("lock key{} value1:[{}] value:[{}]", key, value, value2);
//        }
//        Asserts.assertTrue(lock, ErrorCode.LOCK_ERROR);
//    }
//
//    /**
//     * 解锁
//     *
//     * @param key   key
//     * @param value value
//     * @return 是否释放锁（如果锁不存在，返回true）
//     */
//    public static boolean unlock(String key, String value) {
//        Object obj = SpringUtil.redisTemplate().opsForValue().get(key);
//        if (obj == null) {
//            return true;
//        }
//        if (value.equals(obj.toString())) {
//            return Boolean.TRUE.equals(SpringUtil.redisTemplate().delete(key));
//        }
//        return false;
//    }
//
//    /**
//     * 释放锁，异常场景打印警告日志
//     */
//    public static boolean unlockWithWarn(String key, String value) {
//        Object obj = SpringUtil.redisTemplate().opsForValue().get(key);
//        if (obj == null) {
//            log.warn("释放锁[{}]为空", key);
//            return true;
//        }
//        boolean unlock = false;
//        if (value.equals(obj.toString())) {
//            unlock = Boolean.TRUE.equals(SpringUtil.redisTemplate().delete(key));
//        }
//        if (!unlock) {
//            log.warn("释放锁[{}]失败 value:[{}] actualValue:[{}]", key, value, obj);
//        }
//        return unlock;
//    }
//
//    /**
//     * 随机value
//     *
//     * @return 线程id+随机24位字符串
//     */
//    public static String randomValue() {
//        return Thread.currentThread() + RandomUtils.randomStr(24);
//    }


    /**
     * 生成分布式锁（自动延长）
     *
     * @param key key
     * @return 分布式锁对象
     */
    public static DistributeLock getLock(String key) {
        return new RedissionDistributeLock(key);
    }

    /**
     * 生成分布式锁
     *
     * @param key         key
     * @param expireMills 过期时间(毫秒)
     * @return 分布式锁对象
     */
    public static DistributeLock getLock(String key, long expireMills) {
        return new RedissionDistributeLock(key, expireMills);
    }

    /**
     * 生成分布式锁
     *
     * @param key          key
     * @param maxWaitMills 获取所最长等待时间（毫秒）
     * @param expireMills  过期时间(毫秒)
     * @return 分布式锁对象
     */
    public static DistributeLock getLock(String key, int maxWaitMills, long expireMills) {
        return new RedissionDistributeLock(key, maxWaitMills, expireMills);
    }


}
