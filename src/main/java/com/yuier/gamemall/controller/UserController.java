package com.yuier.gamemall.controller;

import com.yuier.gamemall.pojo.CommonResult;
import com.yuier.gamemall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public CommonResult login(){
        return null;
    }
}
