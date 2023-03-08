package com.my.liufeng.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * om.my.liufeng.provider是为了让工具包生效，而不能导入整个com.my.liufeng包
 */
@EnableDiscoveryClient
@MapperScan(basePackages = "com.my.liufeng.auth.mapper")
@SpringBootApplication(scanBasePackages = {"com.my.liufeng.auth","com.my.liufeng.provider"})
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}
