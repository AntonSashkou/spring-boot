package com.sashkou.clientstarter.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sashkou.domain.User;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties({ClientStarterProperties.class})
public class ClientAutoConfiguration {
    private final ObjectMapper objectMapper;
    private final ClientStarterProperties properties;

    @Bean
    public User deviceDataDeviceService() {
        return Feign.builder()
            .client(new OkHttpClient())
            .encoder(new JacksonEncoder(objectMapper))
            .decoder(new JacksonDecoder(objectMapper))
            .decode404()
            .target(User.class, properties.getHost());
    }
}
