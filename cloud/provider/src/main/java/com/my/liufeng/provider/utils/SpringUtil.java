package com.my.liufeng.provider.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext context = null;
    private static RedisTemplate<String, Object> redisTemplate = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtil.context = applicationContext;
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    static RedisTemplate<String, Object> redisTemplate() {
        if (redisTemplate != null) {
            return redisTemplate;
        }
        synchronized (LockUtil.class) {
            if (redisTemplate != null) {
                return redisTemplate;
            }
            redisTemplate = (RedisTemplate<String, Object>) context.getBean("redisTemplate");
            return redisTemplate;
        }
    }
}
