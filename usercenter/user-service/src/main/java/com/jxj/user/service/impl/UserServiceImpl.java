package com.jxj.user.service.impl;

import com.jxj.user.dao.mapper.UserMapper;
import com.jxj.user.entity.vo.UserVO;
import com.jxj.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

//    @Reference(version="${order.service.version}")
//    private OrderService orderService;

    @Override
    public int signIn(UserVO user) {
        return userMapper.insert(user);
    }

    @Override
    public List<UserVO> list() {
        List<UserVO> list = userMapper.select(new UserVO());
        list.forEach(userVO -> { // TODO 这里看看怎么完善
                userVO.setStatus(findUserStatus(userVO.getId()));
        });
        return list;
    }

    @Override
    public UserVO findUser(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean usableName(String name) {
        UserVO vo = new UserVO();
        vo.setName(name);
        List<UserVO> list = userMapper.select(vo);
        return list == null || list.isEmpty();
    }

    private Integer findUserStatus(Long userId){
        // TODO 调用远程接口，如果有订单
        return UserVO.Status_Invalid;
    }
}
