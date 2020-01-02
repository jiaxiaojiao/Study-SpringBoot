package com.jxj.user.entity.vo;

import lombok.Data;

@Data
public class UserVO {
    private Long id;
    private String name;
    private String password;
    /**
     * 状态：是否为有效用户
     * 1. 有效 0. 无效
     * 订单数>0为有效用户
     */
    private Integer status;

    public static final Integer Status_Invalid = 0; // 无效用户
    public static final Integer Status_Valid = 1; // 有效用户
}
