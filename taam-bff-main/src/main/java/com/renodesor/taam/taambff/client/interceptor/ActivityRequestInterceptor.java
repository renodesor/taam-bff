package com.renodesor.taam.taambff.client.interceptor;

import com.renodesor.taam.taambff.config.ApiConfiguration;
import com.renodesor.taam.taambff.config.TokenGenerator;
import feign.RequestTemplate;

public class ActivityRequestInterceptor extends BaseRequestInterceptor {

    public ActivityRequestInterceptor(TokenGenerator tokenGenerator) {
        super(tokenGenerator);
    }
    @Override
    public void apply(RequestTemplate template) {
        super.apply(template, ApiConfiguration.TAAM_ACTIVITY_CLIENT_NAME);
    }
}
