package com.jxj.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.jxj.order.entity.vo.OrderVO;
import com.jxj.order.entity.vo.ResultVO;
import com.jxj.order.service.OrderService;
import com.jxj.user.openapi.OpenUserService;
import com.jxj.user.openapi.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @Reference(version = "${user.service.version}")
//    private OpenUserService openUserService;

    @NacosInjected
    private NamingService namingService;

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public List<Instance> get(@RequestParam String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }

    @ResponseBody
    @RequestMapping("/place")
    public ResultVO place(OrderVO orderVO){
        if (orderVO == null || StringUtils.isEmpty(orderVO.getItem()) ||
                orderVO.getPrice() == null || !verifyUser(orderVO.getUserId())) {
            return ResultVO.error(ResultVO.ERROR_PARAM, ResultVO.ERROR_PARAM_MSG);
        }

        try {
            OrderVO o = new OrderVO();
            o.setItem(orderVO.getItem());
            o.setPrice(orderVO.getPrice());

            int i = orderService.place(o);
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
        try {
            List<OrderVO> list = orderService.list();
            return ResultVO.success(JSON.toJSONString(list));
        } catch (Exception e) {
            return ResultVO.error(ResultVO.EXCEPTION, e.getMessage());
        }
    }

    private boolean verifyUser(Long userId){
        // 验证用户的真实有效性
//        ResultDTO resultDTO = openUserService.getUser(userId);
//        if (resultDTO.getCode().equals(ResultDTO.SUCCESS) && !resultDTO.getData().isEmpty()) {
//            return true;
//        }
        return false;
    }
}
