package com.wuyou.mapper;

import com.wuyou.model.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<Goods> getGoods();

    Goods getGoodsById(String goodsId);

    List<Goods> selectGoods();
}
