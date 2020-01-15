package com.jxj.user.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 指定Spring扫描路径
 */
@Configuration
@PropertySource("classpath:/dubbo-provider.properties")
public class ProviderConfiguration {
}
