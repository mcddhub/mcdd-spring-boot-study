package com.mcddhub.demo02.controller;

import cn.hutool.http.HttpStatus;
import com.mcddhub.demo02.entity.McddSeries;
import com.mcddhub.demo02.service.McddSeriesService;
import jzxy.mcdd.common.entity.RestBean;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * McddSeriesController
 *
 * @version 1.0.0
 * @author: coder-mcdd
 * @date: 2024/9/8 15:36
 */
@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/mcdd/series")
public class McddSeriesController {
    private final McddSeriesService service;

    @GetMapping
    RestBean<List<McddSeries>> list() {
        List<McddSeries> list = service.list();
        if (Objects.isNull(list)) {
            return RestBean.failure(HttpStatus.HTTP_BAD_REQUEST, "No series found");
        }
        return RestBean.success(list);
    }

    @PostMapping
    RestBean<McddSeries> create(@RequestBody McddSeries series) {
        boolean save = service.save(series);
        return save ? RestBean.success(series) : RestBean.failure(HttpStatus.HTTP_BAD_REQUEST, "Series save failed");
    }
}
