package com.my.liufeng.common.book.vo;

import lombok.Data;

import java.util.List;

/**
 * 调整书籍卷编号
 */
@Data
public class BookPageOrderVO {
    private Long bookId;
    private List<PageOrder> pageOrders;

    @Data
    public static class PageOrder {
        private Long bookPageId;
        private Integer order;
    }
}
