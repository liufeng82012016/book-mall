package com.my.liufeng.provider.config;

import com.my.liufeng.common.enums.ErrorCode;
import com.my.liufeng.common.exception.BrokenException;
import com.my.liufeng.common.utils.JsonUtils;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class FeignConfig {

    @Bean
    public FeignErrorDecoder feignErrorDecoder() {
        return new FeignErrorDecoder();
    }


    public static class FeignErrorDecoder implements ErrorDecoder {

        @Override
        public Exception decode(String methodKey, Response response) {
            try {
                InputStream inputStream = response.body().asInputStream();
                ByteArrayOutputStream result = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) != -1) {
                    result.write(buffer, 0, length);
                }
                String bodyStr = result.toString(StandardCharsets.UTF_8);
                return JsonUtils.read(bodyStr, BrokenException.class);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return new BrokenException(ErrorCode.SYSTEM_ERROR);
        }
    }
}
