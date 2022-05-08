package com.wuyou.service;

import com.wuyou.model.Goods;
import com.wuyou.vo.GoodsDetailVo;
import com.wuyou.vo.GoodsVo;

import java.util.List;

public interface GoodsService {

    List<GoodsVo> getGoods();

    GoodsDetailVo getGoodsDetail(String goodsId);
}
