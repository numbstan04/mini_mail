package com.klose.minimail.controller;

import com.klose.minimail.entity.R;
import com.klose.minimail.entity.WxMember;
import com.klose.minimail.service.WxService;
import com.klose.minimail.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Klose
 * @create 2023-01-16-17:23
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private WxService memberService;

    //根据token返回用户信息
    @GetMapping("getMemberInfo")
    public R getMemberInfo(HttpServletRequest request) {
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        WxMember member = memberService.getById(memberId);
        return R.ok().data("userInfo", member);
    }
}
