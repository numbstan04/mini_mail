package com.klose.minimail.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.klose.minimail.entity.GoodsInfo;
import com.klose.minimail.entity.MemberOrder;
import com.klose.minimail.entity.Order;
import com.klose.minimail.entity.WxMember;
import com.klose.minimail.mapper.GoodsMapper;
import com.klose.minimail.mapper.OrderMapper;
import com.klose.minimail.service.GoodsService;
import com.klose.minimail.service.OrderService;
import com.klose.minimail.service.WxService;
import com.klose.minimail.utils.OrderNoUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Klose
 * @create 2023-01-16-17:38
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    private WxService memberService;

    @Autowired
    private GoodsService goodsService;

    //订单需要商品的图片，名称
    @Override
    public String createOrders(String courseId,int courseCount , String memberId) {
        //通过用户id获取用户信息
        WxMember member = memberService.getById(memberId);
        MemberOrder memberOrder = new MemberOrder();
        BeanUtils.copyProperties(member, memberOrder);

        //通过商品id获取商品信息
        GoodsInfo goodsinfo = goodsService.getGoodsInfoById(courseId);

        //创建Order对象，填充order数据
        Order order = new Order();
        order.setOrderNo(OrderNoUtil.getOrderNo());
        order.setCourseId(courseId);
        order.setStatus(0);//0未支付，1已支付

        //将订单存入数据库
        baseMapper.insert(order);
        return order.getOrderNo();
    }
}
