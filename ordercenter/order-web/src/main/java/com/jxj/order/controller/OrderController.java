package com.jxj.order.controller;

import com.alibaba.fastjson.JSON;
import com.jxj.order.entity.vo.OrderVO;
import com.jxj.order.entity.vo.ResultVO;
import com.jxj.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @Reference(version = "${user.service.version}")
//    private UserService userService;

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
        // TODO 验证用户的真实有效性
//        userService
        return true;
    }
}
