package com.klose.minimail.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Klose
 * @create 2023-01-16-17:39
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    //订单号
    private String orderNo;

    //会员id
    private String memberId;

    //商品id
    private String courseId;

    //购买的商品数量
    private String courseCount;

    //会员昵称
    private String nickname;

    private String mobile;

    private BigDecimal totalFee;

    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
