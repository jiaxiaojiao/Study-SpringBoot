package com.jxj.order.service.fallback;

import com.jxj.order.service.UserClientService;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClientService {
    @Override
    public String list() {
        return "我出错了！";
    }
}
