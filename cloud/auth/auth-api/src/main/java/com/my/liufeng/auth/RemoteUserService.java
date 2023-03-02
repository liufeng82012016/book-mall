package com.my.liufeng.auth;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "auth")
public class RemoteUserService {
}
