package com.dragon.commodityservice.service.impl;

import com.dragon.commodityservice.mapper.CommodityMapper;
import com.dragon.commodityservice.pojo.CommodityInfo;
import com.dragon.commodityservice.pojo.CommodityInfoVO;
import com.dragon.commodityservice.service.CommodityService;
import com.example.feignapi.clients.MerchantClient;
import com.example.feignapi.pojo.MerchantInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MerchantClient merchantClient;

    @Override
    public CommodityInfoVO showCommodityById(String id) {
        CommodityInfo commodity = commodityMapper.selectById(id);
        if (commodity == null){
            CommodityInfoVO vo = new CommodityInfoVO();
            vo.setName("空商品");
            return vo;
        }
        CommodityInfoVO commodityInfoVO = new CommodityInfoVO();
        BeanUtils.copyProperties(commodity,commodityInfoVO);
        MerchantInfo merchantInfo = merchantClient.findById(commodity.getMerchantId());
//        String url = "http://merchant-service/merchant/getMerchantById?id=" + commodity.getMerchantId();
//        MerchantInfo merchantInfo = restTemplate.getForObject(url, MerchantInfo.class);
        commodityInfoVO.setMerchantInfo(merchantInfo);
        return commodityInfoVO;
    }

    @Override
    public int addCommodity(CommodityInfo commodity) {
        int i = commodityMapper.insert(commodity);
        if (i == 1) {
            return i;
        }else {
            throw new RuntimeException("插入失败");
        }
    }
}
