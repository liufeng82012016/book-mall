package com.my.liufeng.api.config;

import com.my.liufeng.common.enums.ErrorCode;
import com.my.liufeng.common.exception.BrokenException;
import com.my.liufeng.common.utils.JsonUtils;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {

    public FeignErrorDecoder() {
        if (log.isDebugEnabled()) {
            log.debug("FeignErrorDecoder init...");
        }
    }

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
            if (log.isDebugEnabled()) {
                log.debug("error:" + bodyStr);
            }
            return JsonUtils.read(bodyStr, BrokenException.class);
        } catch (IOException e) {
            //
        }
        return new BrokenException(ErrorCode.SYSTEM_ERROR);
    }

}
