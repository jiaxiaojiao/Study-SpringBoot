package com.jxj.order.controller;

import com.jxj.order.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务消费端，消费服务 user-provider
 * 服务消费端通过Feign 调用服务
 */
@RestController
public class Consumer2Controller {

    @Autowired
    private UserClientService userClientService;

    @GetMapping("/consumer2")
    public String consumer2(){
        return userClientService.list();
    }
}
