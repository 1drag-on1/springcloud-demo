package com.dragon.merchantservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dragon.merchantservice.pojo.MerchantInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MerchantMapper extends BaseMapper<MerchantInfo> {
}
