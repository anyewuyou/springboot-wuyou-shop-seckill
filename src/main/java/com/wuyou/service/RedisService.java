package com.wuyou.service;

public interface RedisService {
    void initData(String goodsId,int stockNum);

    void initData();
}
