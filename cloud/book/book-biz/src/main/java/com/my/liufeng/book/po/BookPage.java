package com.my.liufeng.book.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 书页表
 * </p>
 *
 * @author liufeng
 * @since 2023-03-10
 */
@TableName("tb_book_page")
@Schema(name = "BookPage对象", description = "书页表")
public class BookPage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(name="id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(name="书籍id")
    private Integer bookId;

    @Schema(name="卷id")
    private Integer pageId;

    @Schema(name="卷标题")
    private String pageTitle;

    @Schema(name="内容")
    private String content;

    @Schema(name="最后更新的管理员id")
    private Integer managerId;

    @Schema(name="创建时间")
    private LocalDateTime createTime;

    @Schema(name="更新时间")
    private LocalDateTime updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "BookPage{" +
        "id=" + id +
        ", bookId=" + bookId +
        ", pageId=" + pageId +
        ", pageTitle=" + pageTitle +
        ", content=" + content +
        ", managerId=" + managerId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
