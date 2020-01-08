package com.jxj.user.service;

import com.jxj.user.entity.vo.UserVO;

import java.util.List;

public interface UserService {
    /**
     * 用户注册
     * @param user
     * @return
     */
    int signIn(UserVO user);

    /**
     * 用户列表（所有用户）
     * @return
     */
    List<UserVO> list();

    /**
     * 查询用户（通过主键用户ID）
     * @param id
     * @return
     */
    UserVO findUser(Long id);

    /**
     * 用户名校验
     * true 可用，false 不可用
     * @param name
     * @return
     */
    boolean usableName(String name);
}
