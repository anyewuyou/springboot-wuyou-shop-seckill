package com.wuyou.controller;

import com.wuyou.service.GoodsService;
import com.wuyou.vo.GoodsDetailVo;
import com.wuyou.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@Controller
//@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/")
    public String /*List<Goods>*/ list(Model model){
        //逐层调用      controller——>service——>dao——>xml
        List<GoodsVo> result=goodsService.getGoods();
        model.addAttribute("goodsList",result);
        return "list";
//        return goodsService.getGoods();
    }

    @GetMapping("/goodsDetail/{goodsId}")
    private String goodsDetail(Model model,
                               @PathVariable String goodsId){
        GoodsDetailVo goodsDetailVo=goodsService.getGoodsDetail(goodsId);
        model.addAttribute("goodsDetailVo",goodsDetailVo);

        Date startTime=goodsDetailVo.getStartTime();
        Date endTime=goodsDetailVo.getEndTime();
        Date nowTime=new Date();

        //判断秒杀的状态
        int status;
        //未开始状态下，倒计时的秒数
        int remainSeconds=-1;
        if (nowTime.before(startTime)){
            //秒杀未开始
            status=0;
            remainSeconds=(int)((startTime.getTime()-nowTime.getTime())/1000);
        }else if(nowTime.after(endTime)){
            //秒杀已结束
            status=2;

        }else{
            //秒杀进行中
            status=1;
        }

        model.addAttribute("status",status);
        model.addAttribute("remainSeconds",remainSeconds);

        return "detail";
    }
}
