package com.my.liufeng.api.config;

import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class FeignConfig {

    public FeignConfig(){
        System.out.println("FeignConfig init...");
    }

    @Bean
    public Logger.Level feignLogLevel() {
        System.out.println(" Logger.Level.FULL init...");
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignErrorDecoder();
    }
}
