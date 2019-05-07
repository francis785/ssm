package com.demo.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.demo.ssm.entity.User;
import com.demo.ssm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "test")
public class UserController {
    @Autowired
    private UserService userService;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @GetMapping(value = "/{id}", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getOneUser(@PathVariable("id") String id) {
        LOGGER.warn("function=getAllUser,id = {}", id);
        User user = userService.getUserById(Long.valueOf(id));
        LOGGER.warn("function=getAllUser,user = {}", JSON.toJSONString(user));
        return JSON.toJSONString(user);
    }

    @PostMapping(value = "/user")
    @ResponseBody
    public String addUser(@RequestBody() User user) {
        LOGGER.warn("function=addUser,user={}", JSON.toJSONString(user));
        int i = userService.addUser(user);
        if (1 == i) {
            return "success";
        } else {
            return "error";
        }
    }
}
