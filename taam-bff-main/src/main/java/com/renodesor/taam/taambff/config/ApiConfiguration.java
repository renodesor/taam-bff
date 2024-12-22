package com.renodesor.taam.taambff.config;

import com.renodesor.taam.taambff.client.interceptor.ActivityRequestInterceptor;
import feign.Feign;
import feign.Retryer;
import feign.httpclient.ApacheHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static java.util.concurrent.TimeUnit.SECONDS;

@Component
public class ApiConfiguration {
    public static final String TAAM_ACTIVITY_CLIENT_NAME = "activity";
    public static final String TAAM_CATEGORY_CLIENT_NAME = "category";

    @Bean
    public ActivityRequestInterceptor activityRequestInterceptor(TokenGenerator tokenGenerator) {
        return new ActivityRequestInterceptor(tokenGenerator);
    }

    /*@Bean
    public CategoryRequestInterceptor categoryRequestInterceptor(TokenGenerator tokenGenerator) {
        return new CategoryRequestInterceptor(tokenGenerator);
    }*/

    @Bean
    public CustomErrorDecoder customErrorDecoder() {
        return new CustomErrorDecoder();
    }

    @Bean
    public Retryer feiggRetryer() {
        return new Retryer.Default(5000, SECONDS.toMinutes(1), 5);
    }

    @Bean
    public Feign.Builder feignBuilder() {
        return Feign.builder().client(new ApacheHttpClient());
    }


}
