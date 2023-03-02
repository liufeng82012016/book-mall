package com.my.liufeng.auth.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author liufeng
 * @since 2023-03-02
 */
@TableName("tb_sys_roles")
@ApiModel(value = "SysRoles对象", description = "")
public class SysRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(name="角色id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(name="角色名称")
    private String name;

    @Schema(name="角色描述")
    private String description;

    @Schema(name="是否锁定(0否 1是)")
    private Boolean available;

    @Schema(name="角色创建时间")
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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
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
        return "SysRoles{" +
        "id=" + id +
        ", name=" + name +
        ", description=" + description +
        ", available=" + available +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}