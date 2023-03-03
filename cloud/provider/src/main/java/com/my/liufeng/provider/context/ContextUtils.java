package com.my.liufeng.provider.context;

import javax.servlet.http.HttpServletRequest;

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

    public static void removeContext(UserContext userContext) {
        contextContainer.remove();
    }
}
