package com.wuyou.vo;

import lombok.Data;

import java.util.Date;

/**
 * 商品详情的展示数据
 */
@Data
public class GoodsDetailVo {
    private String goodsName;
    private String goodsId;
    private String imgPath;
    private Double price;
    private Double seckillPrice;
    private int stockNum;
    private Date startTime;
    private Date endTime;
}
