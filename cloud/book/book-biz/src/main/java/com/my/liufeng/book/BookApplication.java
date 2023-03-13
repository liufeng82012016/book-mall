package com.my.liufeng.book;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan(basePackages = "com.my.liufeng.book.mapper")
@SpringBootApplication(scanBasePackages = {"com.my.liufeng.book", "com.my.liufeng.provider"})
public class BookApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class);
    }
}
