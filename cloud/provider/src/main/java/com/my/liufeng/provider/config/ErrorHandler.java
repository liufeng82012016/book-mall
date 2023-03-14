package com.my.liufeng.provider.config;

import com.my.liufeng.common.Result;
import com.my.liufeng.common.enums.ErrorCode;
import com.my.liufeng.common.exception.BrokenException;
import com.my.liufeng.provider.context.ContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {
    @Value("${spring.application.name}")
    private String moduleName;
    @Value("${liufeng.consumer:false}")
    private boolean consumer;

    public ErrorHandler() {
        log.info("module[{}] ErrorHandler init...", moduleName);
    }

    /**
     * 自定义异常处理
     */
    @ExceptionHandler(BrokenException.class)
    public Result<Void> brokenException(BrokenException brokenException) {
        if (brokenException.getErrorVersion() == 1) {
            // 防止错误日志打印很多次
            log.info("捕获自定义异常 code:{} msg:{}", brokenException.getCode(), brokenException.getMsg(), brokenException);
        }
        if (!consumer) {
            ContextUtils.setHttp500();
        }
        return Result.fail(brokenException);
    }

    /**
     * 处理请求参数异常
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result<Void> paramMissingException(MissingServletRequestParameterException e) {
        log.info("接口参数异常", e);
        if (!consumer) {
            ContextUtils.setHttp500();
        }
        return Result.fail(ErrorCode.PARAM_ERROR, String.format("请求参数：%s不能为空！", e.getParameterName()));
    }

    /**
     * 处理请求体异常
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result<Void> readableException(HttpMessageNotReadableException e) {
        log.info("接口body参数异常", e);
        if (!consumer) {
            ContextUtils.setHttp500();
        }
        return Result.fail(ErrorCode.PARAM_ERROR, "请求参数不能为空");
    }

    /**
     * 处理其他未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public Result<Void> runtimeException(RuntimeException e) {
        log.info("运行时异常", e);
        if (!consumer) {
            ContextUtils.setHttp500();
        }
        return Result.fail(ErrorCode.SYSTEM_ERROR);
    }

    /**
     * 处理其他异常
     */
    @ExceptionHandler(Exception.class)
    public Result<Void> otherException(Exception e) {
        log.info("未知异常", e);
        if (!consumer) {
            ContextUtils.setHttp500();
        }
        return Result.fail(ErrorCode.SYSTEM_ERROR);
    }


}
