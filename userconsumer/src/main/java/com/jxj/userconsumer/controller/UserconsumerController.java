package com.jxj.userconsumer.controller;

import com.jxj.user.openapi.OpenUserService;
import com.jxj.userconsumer.service.UserConsumerService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserconsumerController {
    @Reference(version = "1.0.0", protocol = "dubbo")
    private OpenUserService openUserService; // Reference注解引用服务

    @Autowired
    private UserConsumerService userConsumerService;

    @GetMapping("/user")
    public String user() {
        // 测试dubbo
        return openUserService.getUser(1L).getData();
    }

    @GetMapping("/list")
    public String list(){
        // 测试feign
        return userConsumerService.list();
    }

}
