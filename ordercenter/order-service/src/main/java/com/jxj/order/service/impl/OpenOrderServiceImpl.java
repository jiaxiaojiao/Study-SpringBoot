package com.jxj.order.service.impl;

import com.jxj.order.dao.mapper.OrderMapper;
import com.jxj.order.entity.vo.OrderVO;
import com.jxj.order.openapi.OpenOrderService;
import com.jxj.order.openapi.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenOrderServiceImpl implements OpenOrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public ResultDTO getUserOrderNum(Long userId) {
        try {
            OrderVO vo = new OrderVO();
            vo.setUserId(userId);
            List<OrderVO> list = orderMapper.select(vo);
            return ResultDTO.success(list.size() + "");
        } catch (Exception e) {
            return ResultDTO.error(ResultDTO.EXCEPTION, e.getMessage());
        }
    }
}
