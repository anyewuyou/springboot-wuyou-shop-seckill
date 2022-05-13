package com.wuyou.controller;

import com.wuyou.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class RedisController {
    @Autowired
    private RedisService redisService;

//    @GetMapping("/initData")
//    public String initData(String goodsId,int stockNum){
//        redisService.initData(goodsId, stockNum);
//        return "Success";
//    }
    @GetMapping("/initData")
    public String initData(){
        redisService.initData();
        return "Success";
    }

    @GetMapping("seckillAPI")
    public String seckill(String userId,String goodsId){
        if (userId==null||goodsId==null){
            return "参数异常";
        }
        System.out.println(userId+"---------"+goodsId);
        String result=redisService.secKill(userId, goodsId);
        return result;
    }
}
