package com.jxj.user.service;


import com.jxj.user.entity.vo.UserVO;

import java.util.List;

public interface UserService {
    int signIn(UserVO user);

    List<UserVO> list();

    UserVO findUser(Long id);

    /**
     * 参数name是否可用：
     * true 可用，false 不可用
     */
    boolean usableName(String name);
}
