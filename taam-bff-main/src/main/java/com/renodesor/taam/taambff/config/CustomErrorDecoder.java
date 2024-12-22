package com.renodesor.taam.taambff.config;

import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

import javax.ws.rs.BadRequestException;

@Component
public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, feign.Response response) {
        if (response.status() == 400) {
            return new BadRequestException();
        }
        return defaultErrorDecoder.decode(methodKey, response);
    }
}
