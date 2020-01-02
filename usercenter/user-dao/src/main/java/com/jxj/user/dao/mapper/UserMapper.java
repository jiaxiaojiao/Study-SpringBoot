package com.jxj.user.dao.mapper;

import com.jxj.user.entity.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);
    int insert(UserVO userVO);
    int insertSelective(UserVO userVO);
    UserVO selectByPrimaryKey(Long id);
    List<UserVO> select(UserVO userVO);
}

