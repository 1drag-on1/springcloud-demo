package com.dragon.userservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dragon.userservice.pojo.UserInfo;

public interface UserInfoService extends IService<UserInfo> {

    UserInfo showUserById(String id);

    int addUser(UserInfo userInfo);

}
