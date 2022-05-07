package com.wuyou.service.impl;

import com.wuyou.mapper.GoodsMapper;
import com.wuyou.model.Goods;
import com.wuyou.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getGoods() {
        return goodsMapper.getGoods();
    }
}
