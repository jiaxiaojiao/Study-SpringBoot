package com.jxj.order.service;

import com.jxj.order.entity.vo.OrderVO;

import java.util.List;

public interface OrderService {
    int place(OrderVO order);

    List<OrderVO> list();
}
