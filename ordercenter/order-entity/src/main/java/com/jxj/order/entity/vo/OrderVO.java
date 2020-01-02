package com.jxj.order.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class OrderVO {
    private Long id;
    private String item;
    private Double price;
    private Long userId;
    private Date createdDate;
    private Date modifiedDate;
    private String remark;
}
