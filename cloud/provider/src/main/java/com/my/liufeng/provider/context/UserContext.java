package com.my.liufeng.provider.context;

import com.my.liufeng.provider.support.DistributeLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 上下文环境
 */
public class UserContext {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 单用户并发锁
     */
    private DistributeLock userConcurrentLock;
    private HttpServletRequest request;
    private HttpServletResponse response;


    public UserContext() {
    }

    public UserContext(Integer userId, HttpServletRequest request, HttpServletResponse response) {
        this.userId = userId;
        this.request = request;
        this.response = response;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public DistributeLock getUserConcurrentLock() {
        return userConcurrentLock;
    }

    public void setUserConcurrentLock(DistributeLock userConcurrentLock) {
        this.userConcurrentLock = userConcurrentLock;
    }
}
