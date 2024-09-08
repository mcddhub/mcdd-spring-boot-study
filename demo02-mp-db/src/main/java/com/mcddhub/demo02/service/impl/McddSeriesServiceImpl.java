package com.mcddhub.demo02.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mcddhub.demo02.entity.McddSeries;
import com.mcddhub.demo02.repository.McddSeriesMapper;
import com.mcddhub.demo02.service.McddSeriesService;
import org.springframework.stereotype.Service;

/**
 * McddSeriesServiceImpl
 *
 * @version 1.0.0
 * @author: coder-mcdd
 * @date: 2024/9/8 15:08
 */
@Service
public class McddSeriesServiceImpl extends ServiceImpl<McddSeriesMapper, McddSeries> implements McddSeriesService {
}
