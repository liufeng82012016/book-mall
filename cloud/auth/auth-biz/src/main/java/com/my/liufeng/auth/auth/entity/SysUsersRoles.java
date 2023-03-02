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
@TableName("tb_sys_users_roles")
@ApiModel(value = "SysUsersRoles对象", description = "")
public class SysUsersRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(name="用户角色关系表id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(name="用户id")
    private Long userId;

    @Schema(name="角色id")
    private Long roleId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "SysUsersRoles{" +
        "id=" + id +
        ", userId=" + userId +
        ", roleId=" + roleId +
        "}";
    }
}
