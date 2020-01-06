package com.jxj.user.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.annotation.NacosInjected;
//import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.jxj.user.entity.vo.ResultVO;
import com.jxj.user.entity.vo.UserVO;
import com.jxj.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @NacosValue(value = "${DEFAULT_USER_STATUS:1}", autoRefreshed = true)
//    private Integer userStatus; // 测试Nacos配置

    @NacosInjected
    private NamingService namingService;

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public List<Instance> get(@RequestParam String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }

    @ResponseBody
    @RequestMapping("/signIn")
    public ResultVO signIn(String name, String password){
        // 注册
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            return ResultVO.error(ResultVO.ERROR_PARAM, ResultVO.ERROR_PARAM_MSG);
        }
        if(!userService.usableName(name)){
            return ResultVO.error(ResultVO.ERROR_PARAM, ResultVO.ERROR_PARAM_MSG + "： name重复");
        }
        try {
            UserVO u = new UserVO();
            u.setName(name);
            u.setPassword(password);
//            u.setStatus(userStatus);
            int i = userService.signIn(u);
            if (i >= 1) {
                return ResultVO.success(i + "");
            }
        } catch (Exception e) {
            return ResultVO.error(ResultVO.EXCEPTION, e.getMessage());
        }
        return ResultVO.error(ResultVO.ERROR, ResultVO.ERROR_MSG);
    }

    @ResponseBody
    @RequestMapping("/list")
    public ResultVO list(){
        // 用户列表
        try {
            List<UserVO> list = userService.list();
            return ResultVO.success(JSON.toJSONString(list));
        } catch (Exception e) {
            return ResultVO.error(ResultVO.EXCEPTION, e.getMessage());
        }
    }
}
