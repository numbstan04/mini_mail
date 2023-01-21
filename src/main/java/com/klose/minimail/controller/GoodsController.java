package com.klose.minimail.controller;

import com.klose.minimail.entity.GoodsInfo;
import com.klose.minimail.entity.R;
import com.klose.minimail.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Klose
 * @create 2023-01-15-22:16
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    //获取首页商品列表
    @GetMapping("getAllGoodsInfo")
    public R getAllGoodsInfo() {
        List<GoodsInfo> list = goodsService.getGoodsListByWeight();
        return R.ok().data("allGoodsInfo", list);
    }
}
