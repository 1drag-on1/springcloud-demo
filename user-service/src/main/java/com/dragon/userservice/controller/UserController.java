package com.dragon.userservice.controller;

import com.dragon.userservice.pojo.UserInfo;
import com.dragon.userservice.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Configuration(proxyBeanMethods = false)
@RestController
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/getUserById")
    public UserInfo getUserById(@RequestParam String id){
        return userInfoService.showUserById(id);
    }

    @GetMapping("/addUser")
    public String addUser(@RequestBody UserInfo userInfo){
        int i = userInfoService.addUser(userInfo);
        if (i != 0){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

}
