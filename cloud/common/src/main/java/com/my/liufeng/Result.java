package com.my.liufeng;

import com.my.liufeng.enums.ErrorCode;
import com.my.liufeng.excaption.BrokenException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
        this.code = 0;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(data);
    }

    public static <T> Result<T> fail(ErrorCode error) {
        return new Result<>(error.getCode(), error.getMsg());
    }

    public static <T> Result<T> fail(BrokenException ex) {
        return new Result<>(ex.getCode(), ex.getMsg());
    }
}
