package com.demo.ssm.mapper;

import com.demo.ssm.entity.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}