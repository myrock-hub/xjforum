package com.xjforum.admin.controller;


import com.xjforum.admin.entity.City;
import com.xjforum.admin.service.CityService;
import com.xjforum.admin.util.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: admin
 * \* Date: 2020/12/15
 * \* Time: 16:03
 * \
 */

@RestController
public class helloAdmin {

    @Autowired
    CityService cityService;

    @PostMapping("/helloAdmin")
    @ApiOperation("测试admin")
    public String hello() {
        return "helloadmin";
    }

    @PostMapping("/sel")
    @ApiOperation("测试mapper")
    public ResultUtil sel(@RequestParam("id") int id) {
        City city = cityService.Sel(id);
        List<City> list = new ArrayList<>();
        list.add(city);
        return ResultUtil.ok().data("data", list).message("城市");
    }

    @PostMapping("/citySearch")
    @ApiOperation("条件查询")
    public ResultUtil citySearch(@RequestBody City city,
                                 @RequestParam("page") int page,
                                 @RequestParam("size") int size) {
        return ResultUtil.ok().data("data",cityService.citySearch(city, page, size) ).message("条件查询结果");
    }
}
