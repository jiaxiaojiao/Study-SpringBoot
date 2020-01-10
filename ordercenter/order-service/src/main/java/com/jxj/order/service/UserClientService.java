package com.jxj.order.service;

import com.jxj.order.service.fallback.UserClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
// configuration 使用代码方式，局部配置。
//@FeignClient(name = "user-provider", fallback = UserClientFallback.class, configuration = UserClientConfig.class)
@FeignClient(name = "user-provider", fallback = UserClientFallback.class)
public interface UserClientService {
    /**
     *  @GetMapping(value = "/user/list", headers = {"cache-control=no-cache", "username=jxj@xxx.com"})
     *  其中头部 headers 可以用于以后的身份鉴权
     * @return
     */
    @GetMapping(value = "/user/list", headers = {"cache-control=no-cache", "username=jxj@xxx.com"})
    String list();
}
