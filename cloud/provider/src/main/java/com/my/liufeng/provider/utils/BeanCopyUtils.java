package com.my.liufeng.provider.utils;

import com.my.liufeng.common.enums.ErrorCode;
import com.my.liufeng.common.exception.BrokenException;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanCopyUtils {
    /**
     * beanCopier缓存
     * {
     *     source:{
     *         target: beanCopier
     *     }
     * }
     */
    private static final Map<Class<?>, Map<Class<?>, BeanCopier>> BEAN_COPIER_MAP = new ConcurrentHashMap<>();


    /**
     * 直接指定Bean对象进行拷贝
     *
     * @param sourceBean 输入bean实例
     * @param targetBean 输出bean实例
     * @param <S>        输入beanClass
     * @param <T>        输出beanClass
     */
    public static <S, T> void copy(S sourceBean, T targetBean) {
        @SuppressWarnings("unchecked")
        Class<S> sourceClass = (Class<S>) sourceBean.getClass();
        @SuppressWarnings("unchecked")
        Class<T> targetClass = (Class<T>) targetBean.getClass();

        BeanCopier beanCopier = getBeanCopier(sourceClass, targetClass);
        beanCopier.copy(sourceBean, targetBean, null);
    }

    /**
     * 创建目标对象，并拷贝原对象属性
     *
     * @param sourceBean  原对象
     * @param targetClass 目标类
     * @param <S>         输入beanClass
     * @param <T>         输出beanClass
     * @return 目标对象
     */
    public static <S, T> T convert(S sourceBean, Class<T> targetClass) {
        try {
            assert sourceBean != null;
            T targetBean = targetClass.getDeclaredConstructor().newInstance();
            copy(sourceBean, targetBean);
            return targetBean;
        } catch (Exception e) {
            throw new BrokenException(ErrorCode.BIZ_ERROR);
        }
    }


    /**
     * 获取BeanCopier实例
     *
     * @param sourceClass 输入beanClass
     * @param targetClass 输出beanClass
     * @param <S>         /
     * @param <T>         /
     * @return BeanCopier实例
     */
    private static <S, T> BeanCopier getBeanCopier(Class<S> sourceClass, Class<T> targetClass) {
        Map<Class<?>, BeanCopier> map = BEAN_COPIER_MAP.get(sourceClass);
        if (CollectionUtils.isEmpty(map)) {
            BeanCopier newBeanCopier = BeanCopier.create(sourceClass, targetClass, false);
            Map<Class<?>, BeanCopier> newMap = new ConcurrentHashMap<>();
            newMap.put(targetClass, newBeanCopier);
            BEAN_COPIER_MAP.put(sourceClass, newMap);
            return newBeanCopier;
        }

        BeanCopier beanCopier = map.get(targetClass);
        if (beanCopier != null) {
            return beanCopier;
        }
        BeanCopier newBeanCopier = BeanCopier.create(sourceClass, targetClass, false);
        map.put(targetClass, newBeanCopier);
        return newBeanCopier;
    }
}

