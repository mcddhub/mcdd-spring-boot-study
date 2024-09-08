package com.mcddhub.demo02.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * Mcdd
 *
 * @version 1.0.0
 * @author: coder-mcdd
 * @date: 2024/9/8 14:58
 */
@Data
public class Mcdd {
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 系列 id
     */
    private Integer seriesId;
    /**
     * 名称
     */
    private String name;
    /**
     * 图片地址
     */
    private String imgUrl;
}
