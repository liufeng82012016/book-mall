package com.my.liufeng.provider.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserContext {
    private Integer userId;
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
}
