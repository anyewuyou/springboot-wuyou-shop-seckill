package com.wuyou.mapper;

import com.wuyou.model.SeckillGoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SeckillGoodsMapper {
    SeckillGoods getSeckillGoodsById(String goodsId);

    List<SeckillGoods> getSeckillGoods();
}
