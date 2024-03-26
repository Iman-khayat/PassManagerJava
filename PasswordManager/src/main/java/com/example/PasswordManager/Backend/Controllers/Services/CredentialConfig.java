package com.example.PasswordManager.Services;

import org.apache.commons.codec.digest.Crypt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CredentialConfig {

    @Bean
    public Crypt passwordEncoder() {
        return new Crypt();
    }
}

