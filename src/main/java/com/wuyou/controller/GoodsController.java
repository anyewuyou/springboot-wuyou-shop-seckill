package com.wuyou.controller;

import com.wuyou.model.Goods;
import com.wuyou.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/")
    public /*String*/ List<Goods> list(){
        //逐层调用      controller——>service——>dao——>xml
//        return "list";
        return goodsService.getGoods();
    }
}
