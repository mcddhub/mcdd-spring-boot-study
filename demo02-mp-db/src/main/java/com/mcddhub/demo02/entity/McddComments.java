package com.mcddhub.demo02.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * McddComments
 *
 * @version 1.0.0
 * @author: coder-mcdd
 * @date: 2024/9/8 15:02
 */
@Data
public class McddComments {
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 抹茶旦旦 ID
     */
    private Integer mcddId;
    /**
     * 内容
     */
    private String content;
}
