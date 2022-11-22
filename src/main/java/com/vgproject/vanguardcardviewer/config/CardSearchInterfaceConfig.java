package com.vgproject.vanguardcardviewer.config;

import com.vgproject.vanguardcardviewer.handler.StashErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CardSearchInterfaceConfig {
    @Bean
    public feign.Logger.Level feignLoggerLevel() {
        return feign.Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new StashErrorDecoder();
    }
}
