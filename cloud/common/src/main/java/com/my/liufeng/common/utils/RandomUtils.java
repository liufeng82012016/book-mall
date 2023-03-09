package com.my.liufeng.common.utils;

import java.util.Locale;
import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();
    private static final char[] CHARS = new char[62];

    static {
        for (int i = 0; i < 26; i++) {
            CHARS[i] = (char) (65 + i);
            CHARS[i + 26] = (char) (97 + i);
        }
        for (int i = 0; i < 10; i++) {
            CHARS[52 + i] = (char) (48 + i);
        }
    }

    public static void main(String[] args) {
        System.out.println(randomStr(16));
    }

    /**
     * 生成指定长度的随机字符串
     *
     * @param length 长度
     * @return 随机字符串
     */
    public static String randomStr(int length) {
        return randomStr(length, false);
    }

    /**
     * 生成指定长度的随机字符串
     *
     * @param length        长度
     * @param excludeNumber 是否排除数字
     * @return 随机字符串
     */
    public static String randomStr(int length, boolean excludeNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        int bound = excludeNumber ? 52 : CHARS.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(CHARS[RANDOM.nextInt(bound)]);
        }
        return stringBuilder.toString();
    }

    /**
     * 生成指定长度的随机字符串（大写字母）
     */
    public static String randomStrWithUpperCase(int length, boolean excludeNumber) {
        return randomStr(length, excludeNumber).toUpperCase(Locale.ROOT);
    }

    /**
     * 生成指定长度的随机字符串（小写字母）
     */
    public static String randomStrWithLowerCase(int length, boolean excludeNumber) {
        return randomStr(length, excludeNumber).toLowerCase(Locale.ROOT);
    }
}
