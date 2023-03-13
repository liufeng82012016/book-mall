package com.my.liufeng.common.book.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BookPageDTO {
    @Schema(name = "id")
    private Long id;

    @Schema(name = "书籍id")
    private Integer bookId;

    @Schema(name = "卷id")
    private Integer pageId;

    @Schema(name = "卷标题")
    private String pageTitle;

    @Schema(name = "内容")
    private String content;
}
