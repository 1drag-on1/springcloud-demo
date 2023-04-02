package com.dragon.commodityservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dragon.commodityservice.pojo.CommodityInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommodityMapper extends BaseMapper<CommodityInfo> {
}
