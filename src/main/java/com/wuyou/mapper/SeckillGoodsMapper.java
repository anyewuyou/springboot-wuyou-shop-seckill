package com.wuyou.mapper;

import com.wuyou.model.SeckillGoods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeckillGoodsMapper {
    SeckillGoods getSeckillGoodsById(String goodsId);
}
