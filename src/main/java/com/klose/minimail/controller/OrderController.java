package com.klose.minimail.controller;

import com.klose.minimail.entity.R;
import com.klose.minimail.service.OrderService;
import com.klose.minimail.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Klose
 * @create 2023-01-16-17:33
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //生成订单方法
    @PostMapping("createOrder/{courseId}")
    public R saveOrder(@PathVariable String courseId,int courseCount ,HttpServletRequest request) {
        String orderId = orderService.createOrders(courseId,  courseCount ,JwtUtils.getMemberIdByJwtToken(request));
        return R.ok().data("orderId",orderId);
    }

    //根据订单id查询订单信息


    //根据商品id和用户id查询订单表中订单的状态

}
