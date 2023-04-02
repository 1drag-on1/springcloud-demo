package com.dragon.commodityservice.pojo;

import com.example.feignapi.pojo.MerchantInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommodityInfoVO {

    private String id;

    private String name;
    private Integer price;
    private String merchantId;
    private MerchantInfo merchantInfo;  //商家id对应的商家

    private Date createTime;
    private Date updateTime;
    private Integer deleted;

}
