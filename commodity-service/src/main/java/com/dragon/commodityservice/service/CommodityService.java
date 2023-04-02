package com.dragon.commodityservice.service;

import com.dragon.commodityservice.pojo.CommodityInfo;
import com.dragon.commodityservice.pojo.CommodityInfoVO;

public interface CommodityService {

    CommodityInfoVO showCommodityById(String id);

    int addCommodity(CommodityInfo commodity);

}
