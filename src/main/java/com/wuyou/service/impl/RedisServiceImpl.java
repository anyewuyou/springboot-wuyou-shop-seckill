package com.wuyou.service.impl;

import com.wuyou.mapper.SeckillGoodsMapper;
import com.wuyou.model.SeckillGoods;
import com.wuyou.service.RedisService;
import com.wuyou.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;

    @Override
    public void initData(String goodsId, int stockNum) {
//        存储数据是，设计好key的规则
//        当前需求，通过商品id，找到唯一库存

//        秒杀活动
//        -->在秒杀活动开始前，现有工作人员通过后台管理系统导入数据库中
//        -->再确保redis中存储一份数据用于秒杀时刻使用       应该有额外同步数据的功能
//                    可以从指定的mysql表中，取出需要的数据，初始化到redis中

//        模拟通过请求存储数据
//        自定义key的规则    【goods_id+"_count"】
//        可以通过不同的商品id找到各自的库存数量
//        <"111111_count",10>

//        如果还要设置秒杀开始时间  如何设计key的规则？  【goods_id+"_startTime"】
        redisUtil.set(goodsId+"_count",stockNum);
    }

    @Override
    public void initData() {
        List<SeckillGoods> seckillGoods=seckillGoodsMapper.getSeckillGoods();
        for (SeckillGoods goods : seckillGoods) {
            String goodsId=goods.getGoods_id();
            System.out.println("处理商品id为"+goodsId+"的详细信息");
            redisUtil.set(goodsId+"_count",goods.getStock_num());

            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr=goods.getStart_time().toString();
            try {
                dateStr = format.format(goods.getStart_time());
            }catch (Exception e){

            }
            System.out.println(dateStr);
            redisUtil.set(goodsId+"_startTime",dateStr);

        }
    }
}
