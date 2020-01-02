package com.jxj.order.service.impl;

import com.jxj.order.dao.mapper.OrderMapper;
import com.jxj.order.entity.vo.OrderVO;
import com.jxj.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int place(OrderVO order) {
        return orderMapper.insertSelective(order);
    }

    @Override
    public List<OrderVO> list() {
        // TODO 会根据用户ID展示用户名
        OrderVO vo = new OrderVO();
        return orderMapper.select(vo);
    }
}
