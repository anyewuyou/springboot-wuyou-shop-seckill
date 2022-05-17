package com.wuyou.service.impl;

import com.wuyou.mapper.GoodsMapper;
import com.wuyou.mapper.SeckillGoodsMapper;
import com.wuyou.model.Goods;
import com.wuyou.model.SeckillGoods;
import com.wuyou.service.GoodsService;
import com.wuyou.vo.GoodsDetailVo;
import com.wuyou.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;

    @Override
    public List<GoodsVo> getGoods() {
        //一、通过多表关联一次查出来
        //二、每个表单独查询
        //  从第一个表中查多个数据     再根据每行数据从第二个表中查询
        List<Goods> goodsList=goodsMapper.getGoods();
        List<GoodsVo> result=new ArrayList<>();
        for (Goods goods : goodsList) {

            SeckillGoods seckillGoods=seckillGoodsMapper
                    .getSeckillGoodsById(goods.getGoods_id());

            GoodsVo goodsVo=new GoodsVo();
            goodsVo.setGoodsId(goods.getGoods_id());
            goodsVo.setGoodsName(goods.getGoods_name());
            goodsVo.setGoodsType(goods.getGoods_type());
            goodsVo.setPrice(goods.getPrice());
            goodsVo.setImgPath(goods.getImg_path());

            goodsVo.setSeckillPrice(seckillGoods.getSeckill_price());
            goodsVo.setStockNum(seckillGoods.getStock_num());

            result.add(goodsVo);
        }
        return result;
    }

    @Override
    public GoodsDetailVo getGoodsDetail(String goodsId) {
        Goods goods=goodsMapper.getGoodsById(goodsId);
        SeckillGoods seckillGoods=seckillGoodsMapper.getSeckillGoodsById(goodsId);

        GoodsDetailVo goodsDetailVo=new GoodsDetailVo();
        goodsDetailVo.setGoodsId(goods.getGoods_id());
        goodsDetailVo.setGoodsName(goods.getGoods_name());
        goodsDetailVo.setImgPath(goods.getImg_path());
        goodsDetailVo.setPrice(goods.getPrice());

        goodsDetailVo.setSeckillPrice(seckillGoods.getSeckill_price());
        goodsDetailVo.setStockNum(seckillGoods.getStock_num());
        goodsDetailVo.setStartTime(seckillGoods.getStart_time());
        goodsDetailVo.setEndTime(seckillGoods.getEnd_time());
        return goodsDetailVo;
    }

    @Override
    public List<GoodsVo> selectGoods() {
        List<Goods> goodsList=goodsMapper.selectGoods();
        List<GoodsVo> result=new ArrayList<>();
        for (Goods goods:goodsList){
            GoodsVo goodsVo=new GoodsVo();
            goodsVo.setGoodsId(goods.getGoods_id());
            goodsVo.setGoodsName(goods.getGoods_name());
            goodsVo.setGoodsType(goods.getGoods_type());
            goodsVo.setPrice(goods.getPrice());
            goodsVo.setImgPath(goods.getImg_path());

            goodsVo.setSeckillPrice(goods.getSeckillGoods().getSeckill_price());
            goodsVo.setStockNum(goods.getSeckillGoods().getStock_num());

            result.add(goodsVo);
        }
        return result;
    }

    @Override
    public void reduceStockNum(String goodsId) {
        SeckillGoods seckillGoods=seckillGoodsMapper.getSeckillGoodsById(goodsId);
        seckillGoods.setStock_num(seckillGoods.getStock_num()-1);
        seckillGoodsMapper.reduceStockNum(seckillGoods);
        System.out.println(seckillGoods.getStock_num());
    }


}
