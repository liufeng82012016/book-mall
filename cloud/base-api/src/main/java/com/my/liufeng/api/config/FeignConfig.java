package com.my.liufeng.api.config;

import feign.Logger;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

@Slf4j
public class FeignConfig {

    public FeignConfig() {
        if (log.isDebugEnabled()) {
            log.debug("FeignConfig init...");
        }
    }

    @Bean
    public Logger.Level feignLogLevel() {
        if (log.isDebugEnabled()) {
            log.debug("Logger.Level.FULL init...");
        }
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignErrorDecoder();
    }
}
