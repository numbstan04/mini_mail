package com.klose.minimail.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.klose.minimail.entity.Order;
import com.klose.minimail.entity.WxMember;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Klose
 * @create 2023-01-16-15:45
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
