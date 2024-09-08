package com.mcddhub.demo02.controller;

import cn.hutool.http.HttpStatus;
import com.mcddhub.demo02.entity.McddComments;
import com.mcddhub.demo02.service.McddCommentsService;
import jzxy.mcdd.common.entity.RestBean;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * McddCommentsController
 *
 * @version 1.0.0
 * @author: coder-mcdd
 * @date: 2024/9/8 15:36
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mcdd/comments")
public class McddCommentsController {
    private final McddCommentsService service;

    @GetMapping
    RestBean<List<McddComments>> list() {
        List<McddComments> list = service.list();
        if (Objects.isNull(list)) {
            return RestBean.failure(HttpStatus.HTTP_BAD_REQUEST, "No mcdd found");
        }
        return RestBean.success(list);
    }

    @PostMapping
    RestBean<McddComments> create(@RequestBody McddComments comments) {
        boolean save = service.save(comments);
        return save ? RestBean.success(comments) : RestBean.failure(HttpStatus.HTTP_BAD_REQUEST, "comments save failed");
    }


}
