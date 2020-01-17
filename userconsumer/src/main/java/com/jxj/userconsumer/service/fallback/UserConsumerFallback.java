package com.jxj.userconsumer.service.fallback;

import com.jxj.userconsumer.service.UserConsumerService;
import org.springframework.stereotype.Component;

@Component
public class UserConsumerFallback implements UserConsumerService {
    @Override
    public String list() {
        return "我出错了！";
    }
}
