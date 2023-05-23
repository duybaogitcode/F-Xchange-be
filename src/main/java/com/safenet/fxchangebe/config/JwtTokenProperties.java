package com.safenet.fxchangebe.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class JwtTokenProperties {

    @Value("${APP_SECRET_KEY}")
    private String secret;
    private long expiration = 30 * 60 * 1000;   //30min

    public JwtTokenProperties() {
    }

    public JwtTokenProperties(String secret, long expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }

}
