package com.wz.boot.starter.service;


import com.wz.boot.starter.property.ConsumerProperty;

/**
 * 该service会在自动配置类加载后进行实例化，因而作为starter引入时可以直接@Autwired
 */
public class ConsumerService {

    private String host;
    private String port;

    public ConsumerService(ConsumerProperty consumerProperty) {
        this.host = consumerProperty.getHost();
        this.port = consumerProperty.getPort();
    }

    public void print() {
        System.out.println("host:"+host +",port:"+port);
    }
}
