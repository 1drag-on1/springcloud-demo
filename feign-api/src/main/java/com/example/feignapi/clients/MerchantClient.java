package com.example.feignapi.clients;

import com.example.feignapi.pojo.MerchantInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "merchantservice")
public interface MerchantClient {

    @GetMapping(value = "/merchant/getMerchantById", produces = "application/json;charset=utf-8")
    MerchantInfo findById(@RequestParam("id") String id);

}
