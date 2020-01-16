package com.jxj.user.service.impl;

import com.alibaba.fastjson.JSON;

import com.jxj.user.entity.vo.UserVO;
import com.jxj.user.openapi.OpenUserService;
import com.jxj.user.openapi.dto.ResultDTO;
import com.jxj.user.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * [Dubbo] Service注解暴露服务
 */
@Service(version = "${user.service.version}")
public class OpenUserServiceImpl implements OpenUserService {
    private static Logger logger = LogManager.getLogger(OpenUserServiceImpl.class);
    @Autowired
    private UserService userService;

    @Override
    public ResultDTO getUser(Long id) {
        UserVO userVO = null;
        try {
            userVO = userService.findUser(id);
        } catch (Exception e) {
            logger.error("异常", e);
        }
        return ResultDTO.success(JSON.toJSONString(userVO));
    }
}
