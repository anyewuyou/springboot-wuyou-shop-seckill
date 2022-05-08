package com.wuyou.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
//秒杀商品表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeckillGoods {
    private Long id;
    private String goods_id;
    private Double seckill_price;
    private int stock_num;
    private Date start_time;
    private Date end_time;
}
