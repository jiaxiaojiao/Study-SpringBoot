package com.jxj.order;

import com.jxj.order.service.config.UserClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 启动类。
 * feign全局配置： @EnableFeignClients(basePackages = "com.jxj.order.service", defaultConfiguration = UserClientConfig.class)
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderWebApplication.class, args);
    }

}
