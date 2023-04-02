package com.dragon.merchantservice.service;

import com.dragon.merchantservice.pojo.MerchantInfo;

public interface MerchantService {

    MerchantInfo showUserById(String id);

    int addUser(MerchantInfo commodity);

}
