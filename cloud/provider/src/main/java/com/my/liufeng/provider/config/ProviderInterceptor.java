package com.my.liufeng.provider.config;

import com.my.liufeng.common.Asserts;
import com.my.liufeng.common.enums.ErrorCode;
import com.my.liufeng.common.enums.Header;
import com.my.liufeng.provider.annotations.UserConcurrentLock;
import com.my.liufeng.provider.context.ContextUtils;
import com.my.liufeng.provider.context.UserContext;
import com.my.liufeng.provider.support.DistributeLock;
import com.my.liufeng.provider.utils.LockUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器，设置上下文
 */
@Slf4j
@Component
public class ProviderInterceptor implements HandlerInterceptor {


    public ProviderInterceptor() {
        log.info("ProviderInterceptor init... ");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userId = request.getHeader(Header.USER_ID.getKey());
        UserContext userContext = new UserContext(StringUtils.isBlank(userId) ? null : Integer.parseInt(userId), request, response);
        ContextUtils.setContext(userContext);
        if (log.isDebugEnabled()) {
            log.debug("ProviderInterceptor [{}]set context.userId:[{}]", Thread.currentThread().getId(), userId);
        }
        if (handler instanceof HandlerMethod handlerMethod){
            UserConcurrentLock userConcurrentLock = handlerMethod.getMethodAnnotation(UserConcurrentLock.class);
            if (userConcurrentLock != null) {
                Asserts.assertNotEmpty(userId, ErrorCode.NOT_LOGIN_ERROR);
                String key = "userConcurrent:" + userId;
                DistributeLock lock = LockUtil.getLock(key);
                lock.lock();
                userContext.setUserConcurrentLock(lock);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        ContextUtils.removeContext();
        if (log.isDebugEnabled()) {
            log.debug("ProviderInterceptor [{}]remove context", Thread.currentThread().getId());
        }
    }
}
