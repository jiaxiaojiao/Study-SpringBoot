package com.jxj.order.configuration;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 指定Spring扫描路径
 */
@Configuration
@EnableDubbo(scanBasePackages = "com.jxj.order.controller")
@PropertySource("classpath:/dubbo-consumer.properties")
@ComponentScan(value = {"com.jxj.order.controller"})
public class ConsumerConfiguration {
}
