package com.my.liufeng.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liufeng
 * @since 2023-03-02
 */
@TableName("tb_sys_users_role")
@Schema(name = "SysUsersRole对象", description = "")
public class SysUsersRole implements Serializable {

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
        return "SysUsersRole{" +
        "id=" + id +
        ", userId=" + userId +
        ", roleId=" + roleId +
        "}";
    }
}
