package com.wz.boot.starter.property;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "com.example")
public class ConsumerProperty {

    private String host;
    private String port;
}
