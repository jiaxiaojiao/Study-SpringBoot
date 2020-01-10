package com.jxj.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 服务消费端，消费服务 user-provider
 * 服务消费者这里按照官方文档中的方式通过 RestTemplate+Ribbon进行服务调用
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/consumer")
    public String consumer() {
        String result = restTemplate.getForObject("http://user-provider/user/list",String.class);
        return "Return : " + result;
    }
}
