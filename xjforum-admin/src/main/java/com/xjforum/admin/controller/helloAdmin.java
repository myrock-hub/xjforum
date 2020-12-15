package com.xjforum.admin.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: admin
 * \* Date: 2020/12/15
 * \* Time: 16:03
 * \
 */

@RestController
public class helloAdmin {

    @PostMapping("/helloAdmin")
    @ApiOperation("测试admin")
    public String hello(){
        return "helloadmin";
    }
}
