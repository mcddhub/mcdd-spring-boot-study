package com.mcddhub.demo02.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mcddhub.demo02.entity.McddComments;
import com.mcddhub.demo02.repository.McddCommentsMapper;
import com.mcddhub.demo02.service.McddCommentsService;
import org.springframework.stereotype.Service;

/**
 * McddCommentsServiceImpl
 *
 * @version 1.0.0
 * @author: coder-mcdd
 * @date: 2024/9/8 15:09
 */
@Service
public class McddCommentsServiceImpl extends ServiceImpl<McddCommentsMapper, McddComments> implements McddCommentsService {
}
