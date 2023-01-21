package com.klose.minimail.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.klose.minimail.entity.GoodsInfo;
import com.klose.minimail.entity.MemberOrder;
import com.klose.minimail.entity.WxMember;
import com.klose.minimail.mapper.GoodsMapper;
import com.klose.minimail.mapper.WxMapper;
import com.klose.minimail.service.GoodsService;
import com.klose.minimail.service.WxService;
import org.springframework.stereotype.Service;

/**
 * @author Klose
 * @create 2023-01-16-15:44
 */
@Service
public class WxServiceImpl extends ServiceImpl<WxMapper, WxMember> implements WxService {
    @Override
    public WxMember getOpenIdMember(String openid) {
        QueryWrapper<WxMember> wrapper = new QueryWrapper<>();
        wrapper.eq("openid", openid);
        WxMember member = baseMapper.selectOne(wrapper);
        return member;
    }


}
