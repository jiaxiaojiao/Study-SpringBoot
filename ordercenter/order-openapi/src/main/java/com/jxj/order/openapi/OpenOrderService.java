package com.jxj.order.openapi;

import com.jxj.order.openapi.dto.ResultDTO;

public interface OpenOrderService {
    ResultDTO getUserOrderNum(Long userId);
}
