package com.klose.minimail.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.klose.minimail.entity.GoodsInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Klose
 * @create 2023-01-15-21:44
 */

public interface GoodsService extends IService<GoodsInfo> {
    //根据权值返回首页商品列表
    List<GoodsInfo> getGoodsListByWeight();

    //根据商品id获取商品信息
    GoodsInfo getGoodsInfoById(String courseId);
}
