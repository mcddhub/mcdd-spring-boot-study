package com.mcddhub.demo02.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * McddSeries
 *
 * @version 1.0.0
 * @author: coder-mcdd
 * @date: 2024/9/8 15:00
 */
@Data
public class McddSeries {
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 系列名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;
}
