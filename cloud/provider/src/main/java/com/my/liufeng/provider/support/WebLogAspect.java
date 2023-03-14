package com.my.liufeng.provider.support;

import com.my.liufeng.common.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义切面，打印接口参数和返回值
 */
@Slf4j
@Aspect
@Configuration
public class WebLogAspect {
    @Value("${liufeng.provider.controllerLog:false}")
    private boolean controllerLog;


    @Pointcut("execution(* com.my.liufeng.*.controller..*.*(..))")
    public void webLog() {
    }

    /**
     * 环绕通知
     */
    @Around(value = "webLog()")
    public Object webLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        if (!controllerLog) {
            return joinPoint.proceed();
        }
        String className = joinPoint.getTarget().getClass().getName();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = className +
                "." +
                signature.getMethod().getName() +
                "():";
        log.info("{} 方法原始报文:{}", methodName, JsonUtils.toJsonString(joinPoint.getArgs()));
        Object proceed = joinPoint.proceed();
        log.info("{} 方法响应报文:{}", methodName, JsonUtils.toJsonString(proceed));
        return proceed;
    }
}
