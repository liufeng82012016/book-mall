package com.my.liufeng.excaption;

import com.my.liufeng.enums.ErrorCode;

public class BrokenException extends RuntimeException {

    private int code;
    private String msg;

    public BrokenException() {

    }

    public BrokenException(ErrorCode error) {
        this.code = error.getCode();
        this.msg = error.getMsg();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
