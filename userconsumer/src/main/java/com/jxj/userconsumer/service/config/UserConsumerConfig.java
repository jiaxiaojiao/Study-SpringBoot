package com.jxj.userconsumer.service.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * 配置类
 * 注： 如果不是全局配置，类上不要添加注解 @Configuration
 * 如果是全局配置，类上也添加注解 @Configuration，可以在启动类配置。
 */
public class UserConsumerConfig {

    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
    }
}
