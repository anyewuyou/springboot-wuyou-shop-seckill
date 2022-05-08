package com.wuyou.controller;

import com.wuyou.model.Goods;
import com.wuyou.service.GoodsService;
import com.wuyou.vo.GoodsDetailVo;
import com.wuyou.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
        return "detail";
    }
}
