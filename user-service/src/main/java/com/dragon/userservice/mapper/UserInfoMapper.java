package com.dragon.userservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dragon.userservice.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
