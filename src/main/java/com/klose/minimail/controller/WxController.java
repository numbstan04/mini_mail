package com.klose.minimail.controller;

import com.google.gson.Gson;
import com.klose.minimail.entity.MemberOrder;
import com.klose.minimail.entity.R;
import com.klose.minimail.entity.WxMember;
import com.klose.minimail.service.WxService;
import com.klose.minimail.utils.ConstantWxUtils;
import com.klose.minimail.utils.HttpClientUtils;
import com.klose.minimail.utils.JwtUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author Klose
 * @create 2023-01-15-23:56
 */
@RestController
@RequestMapping("/wx")
public class WxController {

    @Autowired
    private WxService memberService;

    @GetMapping("wxLogin")
    public R wxLogin(String code) {
        try {
            String baseAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token" +
                    "?appid=%s" +
                    "&secret=%s" +
                    "&code=%s" +
                    "&grant_type=authorization_code";

            String accessTokenUrl = String.format(
                    baseAccessTokenUrl,
                    ConstantWxUtils.WX_OPEN_APP_ID,
                    ConstantWxUtils.WX_OPEN_APP_SECRET,
                    code
            );
            String accessTokenInfo = HttpClientUtils.get(accessTokenUrl);

            Gson gson = new Gson();
            HashMap mapAccessToken = gson.fromJson(accessTokenInfo, HashMap.class);
            String access_token = (String) mapAccessToken.get("access_token");
            String openid = (String) mapAccessToken.get("openid");
            WxMember member = memberService.getOpenIdMember(openid);

            if (member == null) {//memeber是空，表没有相同微信数据，进行添加

                //3 拿着得到accsess_token 和 openid，再去请求微信提供固定的地址，获取到扫描人信息
                //访问微信的资源服务器，获取用户信息
                String baseUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo" +
                        "?access_token=%s" +
                        "&openid=%s";
                //拼接两个参数
                String userInfoUrl = String.format(
                        baseUserInfoUrl,
                        access_token,
                        openid
                );
                //发送请求
                String userInfo = HttpClientUtils.get(userInfoUrl);
                //获取返回userinfo字符串扫描人信息
                HashMap userInfoMap = gson.fromJson(userInfo, HashMap.class);
                String nickname = (String) userInfoMap.get("nickname");//昵称
                String headimgurl = (String) userInfoMap.get("headimgurl");//头像

                member = new WxMember();
                member.setOpenid(openid);
                member.setNickname(nickname);
                member.setAvatar(headimgurl);
                memberService.save(member);
            }

            String jwtToken = JwtUtils.getJwtToken(member.getId(), member.getNickname());

            return R.ok().data("wxToken", jwtToken);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("getUserInfoOrder/{id}")
    public MemberOrder getUserInfoOrder(@PathVariable String id) {
        WxMember member = memberService.getById(id);
        MemberOrder memberOrder = new MemberOrder();
        BeanUtils.copyProperties(member, memberOrder);
        return memberOrder;
    }
}
