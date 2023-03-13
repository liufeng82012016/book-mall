package com.my.liufeng.common.enums;

public enum ErrorCode {
    /**
     * 系统通用异常
     */
    LOCK_ERROR(1001, "请稍后再试"),
    SYSTEM_ERROR(1002, "系统繁忙"),
    DATA_ERROR(1101, "数据异常"),
    PARAM_ERROR(1102, "参数异常"),
    BIZ_ERROR(1103, "未知异常"),
    /**
     * 用户模块自定义异常
     */
    ACCOUNT_FORMAT_ERROR(10001, "账号格式错误"),
    ACCOUNT_REPEAT_ERROR(10002, "账号已存在"),
    PASSWORD_FORMAT_ERROR(10003, "密码格式错误"),
    SECRET_EXPIRED_ERROR(10004, "密钥已过期"),
    DYNAMIC_PASSWORD_ERROR(10005, "动态口令错误"),
    ACCOUNT_EMPTY_ERROR(10006, "账号不存在"),
    PASSWORD_ERROR(10007, "密码错误"),

    /**
     * 书籍模块自定义异常
     */
    DYNASTY_NOT_EXIST(20001,"朝代不存在"),
    AUTHOR_NOT_EXIST(20002,"作者不存在"),
    BOOK_NOT_EXIST(20003,"书籍不存在"),
    BOOK_PAGE_EXIST(20004,"书卷号重复"),
    ;
    private int code;
    private String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
