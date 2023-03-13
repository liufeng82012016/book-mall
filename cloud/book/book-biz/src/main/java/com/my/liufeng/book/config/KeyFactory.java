package com.my.liufeng.book.config;

/**
 * key工厂类
 */
public enum KeyFactory {
    /**
     * 书籍管理
     */
    BOOK("book:"),
    BOOK_PAGE("bookPage:"),
    BOOK_PAGE_ORDER("bookPage:order:")
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
