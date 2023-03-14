package com.my.liufeng.provider.context;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class ContextUtils {

    private static ThreadLocal<UserContext> contextContainer = new ThreadLocal<>();

    public static Integer getUserId() {
        return contextContainer.get().getUserId();
    }

    private static HttpServletRequest getRequest() {
        return contextContainer.get().getRequest();
    }

    public static void setContext(UserContext userContext) {
        contextContainer.set(userContext);
    }

    public static void removeContext() {
        UserContext userContext = contextContainer.get();
        if (userContext != null && userContext.getUserConcurrentLock() != null) {
            userContext.getUserConcurrentLock().unlock();
        }
        contextContainer.remove();
    }

    public static void setHttp500() {
        UserContext userContext = contextContainer.get();
        if (userContext != null) {
            userContext.getResponse().setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            if (log.isDebugEnabled()) {
                log.debug("request[{}] 设置status500", userContext.getRequest().getRequestURI());
            }
        } else {
            if (log.isDebugEnabled()) {
                log.info("context is null");
            }
        }
    }

}
