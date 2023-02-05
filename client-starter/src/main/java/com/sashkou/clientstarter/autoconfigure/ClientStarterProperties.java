package com.sashkou.clientstarter.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "client.starter")
public class ClientStarterProperties {

    private String host = "http://localhost:8080";
}
