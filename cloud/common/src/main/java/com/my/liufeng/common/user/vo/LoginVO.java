package com.my.liufeng.common.user.vo;

import com.my.liufeng.common.utils.TrimUtils;

public class LoginVO {
    private String account;
    private String password;
    private Long code;
    /**
     * 是否后台管理系统登录
     */
    private Boolean admin;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        account = TrimUtils.trim(account);
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = TrimUtils.trim(password);
        this.password = password;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
