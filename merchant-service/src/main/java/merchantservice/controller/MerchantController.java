package com.dragon.merchantservice.controller;

import com.alibaba.nacos.common.utils.JacksonUtils;
import com.dragon.merchantservice.configuration.PatternProperties;
import com.dragon.merchantservice.pojo.MerchantInfo;
import com.dragon.merchantservice.service.MerchantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@Api(tags = "商家模块")
@RequestMapping("/merchant")
//@RefreshScope  //热部署
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private PatternProperties patternProperties;

//    @Value("${pattern.dateformat}")
//    private String dateformat;

    @GetMapping("/")
    public PatternProperties properties(){
        return patternProperties;
    }

    @GetMapping("/now")
    public String now(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDateFormat()));
    }

    @GetMapping("/getMerchantById")
    @ApiOperation(value = "按id查询", response = MerchantInfo.class, httpMethod = "GET")
    public String getMerchantById(@RequestParam String id,@RequestHeader(required = false) String truth) {
        System.out.println(truth);
        MerchantInfo merchantInfo = merchantService.showUserById(id);
        return JacksonUtils.toJson(merchantInfo);
    }

    @PostMapping("/addMerchant")
    @ApiOperation(value = "添加一个商家", response = String.class, httpMethod = "POST")
    public String addMerchant(@RequestBody MerchantInfo merchant) {
        int i = merchantService.addUser(merchant);
        if (i != 0) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }
}
