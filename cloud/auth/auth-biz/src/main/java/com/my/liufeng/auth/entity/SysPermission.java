package com.my.liufeng.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author liufeng
 * @since 2023-03-02
 */
@TableName("tb_sys_permission")
@Schema(name = "SysPermission对象", description = "")
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(name="权限id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(name="权限名称")
    private String name;

    @Schema(name="权限描述")
    private String description;

    @Schema(name="权限访问路径")
    private String url;

    @Schema(name="类型   0：目录   1：菜单   2：按钮")
    private Boolean type;

    @Schema(name="排序")
    private Integer order;

    @Schema(name="图标")
    private String icon;

    @Schema(name="状态：0有效；1删除")
    private Boolean status;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
        return "SysPermission{" +
        "id=" + id +
        ", name=" + name +
        ", description=" + description +
        ", url=" + url +
        ", type=" + type +
        ", order=" + order +
        ", icon=" + icon +
        ", status=" + status +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
