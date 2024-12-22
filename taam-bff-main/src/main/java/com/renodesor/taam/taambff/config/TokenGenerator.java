package com.renodesor.taam.taambff.config;

import com.renodesor.taam.taambff.Constants;
import org.springframework.stereotype.Component;

@Component
public class TokenGenerator {
    public String getToken(String clientName) {
        return Constants.TAAM_TOKEN;
    }
}
