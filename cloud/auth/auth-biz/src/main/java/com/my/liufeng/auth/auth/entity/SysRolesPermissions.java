package com.my.liufeng.auth.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("tb_sys_roles_permissions")
@ApiModel(value = "SysRolesPermissions对象", description = "")
public class SysRolesPermissions implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(name="角色权限关系表id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(name="角色id")
    private Long roleId;

    @Schema(name="权限id")
    private Long permissionId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "SysRolesPermissions{" +
        "id=" + id +
        ", roleId=" + roleId +
        ", permissionId=" + permissionId +
        "}";
    }
}
