package com.mcddhub.demo02.controller;

import cn.hutool.http.HttpStatus;
import com.mcddhub.demo02.entity.Mcdd;
import com.mcddhub.demo02.service.McddService;
import jzxy.mcdd.common.entity.RestBean;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * McddController
 *
 * @version 1.0.0
 * @author: coder-mcdd
 * @date: 2024/9/8 15:05
 */
@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/mcdd/mcdds")
public class McddController {

    private final McddService service;


    @GetMapping
    RestBean<List<Mcdd>> list() {
        List<Mcdd> list = service.list();
        if (Objects.isNull(list)) {
            return RestBean.failure(HttpStatus.HTTP_BAD_REQUEST, "No mcdd found");
        }
        return RestBean.success(list);
    }

    @PostMapping
    RestBean<Mcdd> create(@RequestBody Mcdd mcdd) {
        boolean save = service.save(mcdd);
        return save ? RestBean.success(mcdd) : RestBean.failure(HttpStatus.HTTP_BAD_REQUEST, "mcdd save failed");
    }

}
