package com.my.liufeng.auth;

import com.my.liufeng.api.config.FeignConfig;
import com.my.liufeng.common.user.dto.RegisterDTO;
import com.my.liufeng.common.user.vo.LoginVO;
import com.my.liufeng.common.user.vo.RegisterVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "auth", configuration = FeignConfig.class)
public interface RemoteUserService {
    @GetMapping(value = "/auth/public/getSecret")
    String getSecret(@RequestParam String account);

    @PostMapping("/auth/public/register")
    RegisterDTO register(@RequestBody RegisterVO registerVO);

    @PostMapping("/auth/public/login")
    RegisterDTO login(@RequestBody LoginVO loginVO);
}
