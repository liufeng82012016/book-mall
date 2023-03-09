package com.my.liufeng.common.enums;

public enum Header {
    /**
     * token
     */
    AUTHENTICATION("Authentication"),
    /**
     * 用户id
     */
    USER_ID("UserId")
    ;
    private final String key;

    Header(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
