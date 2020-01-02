package com.jxj.order.dao.mapper;

import com.jxj.order.entity.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Long id);
    int insert(OrderVO orderVO);
    int insertSelective(OrderVO orderVO);
    OrderVO selectByPrimaryKey(Long id);
    List<OrderVO> select(OrderVO orderVO);
}
