package com.sashkou.clientstarter.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sashkou.clientstarter.service.UserRestClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties({ClientStarterProperties.class})
public class ClientAutoConfiguration {
    private final ObjectMapper objectMapper;
    private final ClientStarterProperties properties;

    @Bean
    public UserRestClient userRestClient() {
        log.info("Configuring userRestClient");

        return Feign.builder()
            .client(new OkHttpClient())
            .encoder(new JacksonEncoder(objectMapper))
            .decoder(new JacksonDecoder(objectMapper))
            .decode404()
            .target(UserRestClient.class, properties.getHost());
    }
}
