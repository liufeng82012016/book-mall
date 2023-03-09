package com.my.liufeng.auth.config;

/**
 * key工厂类
 */
public enum KeyFactory {
    /**
     * 动态口令
     */
    SECRET("secret:"),
    REGISTER("register:"),
    LOGIN("login:")
    ;

    KeyFactory(String prefix) {
        this.prefix = prefix;
    }

    private final String prefix;

    /**
     * 生成key
     *
     * @param content key唯一标记
     * @return key
     */
    public String getKey(String content) {
        return prefix + content;
    }
}
