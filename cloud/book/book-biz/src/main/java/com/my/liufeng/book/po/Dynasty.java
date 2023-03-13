package com.my.liufeng.book.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 朝代表
 * </p>
 *
 * @author liufeng
 * @since 2023-03-10
 */
@TableName("tb_dynasty")
@Schema(name = "Dynasty对象", description = "朝代表")
public class Dynasty implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(name="id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(name="名称")
    private String name;

    @Schema(name="介绍")
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "Dynasty{" +
        "id=" + id +
        ", name=" + name +
        ", description=" + description +
        ", managerId=" + managerId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
