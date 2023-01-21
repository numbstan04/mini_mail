package com.klose.minimail.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.klose.minimail.entity.MemberOrder;
import com.klose.minimail.entity.WxMember;

/**
 * @author Klose
 * @create 2023-01-16-15:34
 */
public interface WxService extends IService<WxMember> {

    WxMember getOpenIdMember(String openid);


}
