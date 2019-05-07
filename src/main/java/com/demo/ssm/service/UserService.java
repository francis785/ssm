package com.demo.ssm.service;

import com.demo.ssm.entity.User;
import com.demo.ssm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService{

    @Autowired
    private UserMapper userDao;

    public User getUserById(Long id){
        return userDao.selectByPrimaryKey(id);
    }

    public int addUser(User user){
        return userDao.insert(user);
    }

}
