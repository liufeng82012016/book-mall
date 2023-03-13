package com.my.liufeng.book.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 作者表
 * </p>
 *
 * @author liufeng
 * @since 2023-03-10
 */
@TableName("tb_author")
@Schema(name = "Author对象", description = "作者表")
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(name="id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(name="姓名")
    private String name;

    @Schema(name="朝代")
    private Integer dynasty;

    @Schema(name="介绍")
    private String description;

    @Schema(name="标签列表")
    private String tags;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDynasty() {
        return dynasty;
    }

    public void setDynasty(Integer dynasty) {
        this.dynasty = dynasty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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
        return "Author{" +
        "id=" + id +
        ", name=" + name +
        ", dynasty=" + dynasty +
        ", description=" + description +
        ", tags=" + tags +
        ", managerId=" + managerId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
