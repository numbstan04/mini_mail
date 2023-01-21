package com.klose.minimail.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.klose.minimail.entity.GoodsInfo;
import com.klose.minimail.mapper.GoodsMapper;
import com.klose.minimail.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Klose
 * @create 2023-01-15-21:47
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, GoodsInfo> implements GoodsService {

    //通过权值返回商品首页列表
    @Override
    public List<GoodsInfo> getGoodsListByWeight() {
        QueryWrapper<GoodsInfo> wrapper = new QueryWrapper<>();
        List<GoodsInfo> goodsList = baseMapper.selectList(wrapper);

        return goodsList;
    }

    @Override
    public GoodsInfo getGoodsInfoById(String courseId) {
        QueryWrapper<GoodsInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("courseId",courseId);
        GoodsInfo goodsInfo = baseMapper.selectById(wrapper);

        return goodsInfo;
    }
}
