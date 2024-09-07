package com.mcddhub.demo01.controller;

import org.springframework.web.bind.annotation.*;

/**
 * TestController
 *
 * @version 1.0.0
 * @author: caobaoqi1029
 * @date: 2024/9/6 21:04
 */
@RestController
@RequestMapping("/api/tests")
public class TestController {

    @PostMapping
    public String sayHello(@RequestParam(name = "name") String name) {
        return "Hello Name is " + name;
    }
}
