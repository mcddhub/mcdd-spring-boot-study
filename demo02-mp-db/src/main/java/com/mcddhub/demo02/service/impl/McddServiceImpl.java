package com.mcddhub.demo02.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mcddhub.demo02.entity.Mcdd;
import com.mcddhub.demo02.repository.McddMapper;
import com.mcddhub.demo02.service.McddService;
import org.springframework.stereotype.Service;

/**
 * McddServiceImpl
 *
 * @version 1.0.0
 * @author: coder-mcdd
 * @date: 2024/9/8 15:08
 */
@Service
public class McddServiceImpl extends ServiceImpl<McddMapper, Mcdd> implements McddService {
}
