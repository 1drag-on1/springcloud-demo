package com.dragon.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragon.userservice.mapper.UserInfoMapper;
import com.dragon.userservice.pojo.UserInfo;
import com.dragon.userservice.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper,UserInfo> implements UserInfoService{

    @Autowired
    private UserInfoMapper userMapper;
    @Autowired
    private UserInfoService userInfoService;

    @Override
    public UserInfo showUserById(String id) {
        return userMapper.selectById(id);
    }

    @Override
    public int addUser(UserInfo userInfo) {
        int i = userMapper.insert(userInfo);
        if (i == 1) {
            return i;
        }else {
            throw new RuntimeException("插入失败");
        }
    }
}
