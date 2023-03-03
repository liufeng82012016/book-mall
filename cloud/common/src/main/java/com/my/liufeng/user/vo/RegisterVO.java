package com.my.liufeng.user.vo;

import com.my.liufeng.utils.TrimUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class RegisterVO {
    private String account;
    private String password;
    private Long code;
    private String secret;

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

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
