package com.my.liufeng.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
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
@TableName("tb_sys_user")
@Schema(name = "SysUser对象", description = "")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(name="用户id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(name="账号")
    private String account;

    @Schema(name="密码")
    private String password;

    @Schema(name="性别 0男 1女")
    private Boolean sex;

    @Schema(name="身份证")
    private String idCard;

    @Schema(name="邮箱")
    private String email;

    @Schema(name="电话")
    private String phone;

    @Schema(name="状态(0启用 1冻结 2删除)")
    private Boolean status;

    @Schema(name="用户创建时间")
    private LocalDateTime createTime;

    @Schema(name="最后登录时间")
    private LocalDateTime lastTime;

    @Schema(name="加密盐值")
    private String salt;

    @Schema(name="年龄")
    private Integer age;

    @Schema(name="个人账号密钥")
    private String secret;

    @Schema(name="0-普通用户 1-普通管理员 2-超级管理员")
    private Integer manager;

    @Schema(name="更新时间")
    private LocalDateTime updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public LocalDateTime getLastTime() {
        return lastTime;
    }

    public void setLastTime(LocalDateTime lastTime) {
        this.lastTime = lastTime;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "SysUser{" +
        "id=" + id +
        ", account=" + account +
        ", password=" + password +
        ", sex=" + sex +
        ", idCard=" + idCard +
        ", email=" + email +
        ", phone=" + phone +
        ", status=" + status +
        ", createTime=" + createTime +
        ", lastTime=" + lastTime +
        ", salt=" + salt +
        ", age=" + age +
        ", secret=" + secret +
        ", manager=" + manager +
        ", updateTime=" + updateTime +
        "}";
    }
}
