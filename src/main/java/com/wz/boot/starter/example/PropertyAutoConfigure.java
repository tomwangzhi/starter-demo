package com.wz.boot.starter.example;


import com.wz.boot.starter.property.ConsumerProperty;
import com.wz.boot.starter.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConditionalOnClass(ConsumerService.class)  // 有ConsumerService才加载自动化配置类
@EnableConfigurationProperties(ConsumerProperty.class) // 设置属性
public class PropertyAutoConfigure {

    @Autowired
    private ConsumerProperty consumerProperty;

    @ConditionalOnMissingBean(ConsumerService.class)
    @ConditionalOnProperty(prefix = "com.example",value = "enabled", havingValue = "true")
    @Bean
    public ConsumerService consumerService() {
        ConsumerService consumerService = new ConsumerService(consumerProperty);
        return consumerService;
    }
}
