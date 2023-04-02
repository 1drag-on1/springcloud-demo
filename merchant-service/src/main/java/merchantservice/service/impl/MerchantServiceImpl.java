package com.dragon.merchantservice.service.impl;

import com.dragon.merchantservice.mapper.MerchantMapper;
import com.dragon.merchantservice.pojo.MerchantInfo;
import com.dragon.merchantservice.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public MerchantInfo showUserById(String id) {
        return merchantMapper.selectById(id);
    }

    @Override
    public int addUser(MerchantInfo merchant) {
        int i = merchantMapper.insert(merchant);
        if (i == 1) {
            return i;
        }else {
            throw new RuntimeException("插入失败");
        }
    }
}
