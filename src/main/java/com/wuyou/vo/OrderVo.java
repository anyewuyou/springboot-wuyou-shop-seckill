package com.wuyou.vo;

import lombok.Data;

import java.util.Date;

@Data
public class OrderVo {
    private String goodsName;
    private String imgPath;
    private Double price;
    private Date createTime;
    private String telephone;
    private String address;
    private int status;
}
