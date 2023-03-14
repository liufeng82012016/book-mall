package com.my.liufeng.provider.support;

import com.my.liufeng.common.Asserts;
import com.my.liufeng.common.enums.ErrorCode;
import com.my.liufeng.provider.utils.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

@Slf4j
public class RedissionDistributeLock implements DistributeLock {

    private RedissonClient redissonClient;

    /**
     * redisson锁
     */
    private final RLock rLock;
    /**
     * 加锁最大等待时间
     */
    int maxWaitMills;
    /**
     * 过期时间
     */
    long expireMills;

    private RedissonClient getRedissonClient() {
        if (redissonClient != null) {
            return redissonClient;
        }
        synchronized (this) {
            if (redissonClient != null) {
                return redissonClient;
            }
            redissonClient = (RedissonClient) SpringUtil.getBean(RedissonClient.class);
            return redissonClient;
        }
    }

    public RedissionDistributeLock(String key) {
        this.rLock = getRedissonClient().getLock(key);
        this.maxWaitMills = 100;
        this.expireMills = -1;
    }

    public RedissionDistributeLock(String key, long expireMills) {
        this.rLock = getRedissonClient().getLock(key);
        this.maxWaitMills = 100;
        this.expireMills = expireMills;
    }


    public RedissionDistributeLock(String key, int maxWaitMills, long expireMills) {
        this.rLock = getRedissonClient().getLock(key);
        this.maxWaitMills = maxWaitMills;
        this.expireMills = expireMills;
    }

    @Override
    public boolean tryLock() {
        try {
            return rLock.tryLock(maxWaitMills, expireMills, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            //
            return false;
        }
    }

    @Override
    public void lock() {
        lock(ErrorCode.LOCK_ERROR);
    }

    @Override
    public void lock(ErrorCode errorCode) {
        Asserts.assertTrue(tryLock(), errorCode);
    }

    @Override
    public void unlock() {
        if (!rLock.isLocked()) {
            log.info("释放锁[{}]时，锁不存在", rLock.getName());
            return;
        }
        rLock.unlock();
    }
}
