package com.renodesor.taam.taambff.client.interceptor;

import com.renodesor.taam.taambff.config.TokenGenerator;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public abstract class BaseRequestInterceptor implements RequestInterceptor {

    private final TokenGenerator tokenGenerator;

    protected BaseRequestInterceptor(TokenGenerator tokenGenerator) {
        this.tokenGenerator = tokenGenerator;
    }


    public void apply(final RequestTemplate requestTemplate, String clientName) {
        requestTemplate.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        requestTemplate.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        requestTemplate.header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenGenerator.getToken(clientName));
    }
}
