package com.my.liufeng.common.utils;

import com.my.liufeng.common.Asserts;
import com.my.liufeng.common.enums.ErrorCode;

import java.util.regex.Pattern;

public class RegUtils {

    /**
     * 账号正则
     */
    private static final Pattern ACCOUNT_PATTERN = Pattern.compile("^[\u4e00-\u9fa5a-zA-Z0-9]{8,40}$");
    /**
     * 手机号正则
     */
    private static final Pattern MOBILE_PATTERN = Pattern.compile("^1[0-9]{8}$");
    /**
     * 密码正则
     */
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9]{8,20}$");

    public static boolean accountMatch(String account, ErrorCode error) {
        Asserts.assertNotEmpty(account, error);
        return ACCOUNT_PATTERN.matcher(account.trim()).matches();
    }

    public static boolean mobileMatch(String account, ErrorCode error) {
        Asserts.assertNotEmpty(account, error);
        return MOBILE_PATTERN.matcher(account.trim()).matches();
    }

    public static boolean passwordMatch(String account, ErrorCode error) {
        Asserts.assertNotEmpty(account, error);
        return PASSWORD_PATTERN.matcher(account.trim()).matches();
    }
}
