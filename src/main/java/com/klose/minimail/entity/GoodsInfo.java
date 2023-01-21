package com.klose.minimail.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Klose
 * @create 2023-01-15-21:35
 */
@Data
@TableName("k_goodslist")
public class GoodsInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String image;

    private boolean status;

    private String title;

    private BigDecimal price;
}
