package com.angel.restexample.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties("app.config")
public class AppConfig {

    private String passwordRegex;
}
