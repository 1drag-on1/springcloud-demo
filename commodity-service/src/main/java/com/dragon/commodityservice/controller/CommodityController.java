package com.dragon.commodityservice.controller;

import com.dragon.commodityservice.pojo.CommodityInfo;
import com.dragon.commodityservice.pojo.CommodityInfoVO;
import com.dragon.commodityservice.service.CommodityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @GetMapping("/getCommodityById")
    public CommodityInfoVO getCommodityById(@RequestParam String id){
        return commodityService.showCommodityById(id);
    }

    @GetMapping("/addCommodity")
    public String addCommodity(@RequestBody CommodityInfo commodity){
        int i = commodityService.addCommodity(commodity);
        if (i != 0){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }
}
