package com.jxj.user.configuration;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 指定Spring扫描路径
 */
@Configuration
@EnableDubbo(scanBasePackages = "com.jxj.user.service.impl")
@PropertySource("classpath:/dubbo-provider.properties")
public class ProviderConfiguration {
}
