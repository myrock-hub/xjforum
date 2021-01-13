package com.xjforum.admin.controller;


import com.xjforum.admin.entity.City;
import com.xjforum.admin.service.CityService;
import com.xjforum.admin.util.ResultUtil;
import io.swagger.annotations.Api;
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
@Api(tags = {"admin"})
@RestController
public class Admin {

    @Autowired
    CityService cityService;

    @PostMapping("/helloAdmin")
    @ApiOperation("测试admin")
    public String hello() {
        return "helloadmin";
    }

    @PostMapping("/selectById")
    @ApiOperation("selectById")
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

    @PostMapping("/updateCityByMapper")
    @ApiOperation("修改City")
    public ResultUtil updateCity(@RequestBody City city ) {
        int result = cityService.updateCity(city);
        if (result>0){
            city.setID(cityService.getID(city.getName()));
            return ResultUtil.ok().data("data",city).message("修改成功");
        }else {
            return ResultUtil.error().message("修改失败");
        }

    }

    @PostMapping("/deleteCityByMapper")
    @ApiOperation("删除City")
    public ResultUtil deleteCity(@RequestParam String Name ) {
        int result = cityService.deleteCity(Name);
        if (result>0){
            return ResultUtil.ok().data("data",result).message("删除成功");
        }else {
            return ResultUtil.error().message("删除失败");
        }

    }
    @PostMapping("/addCityByMapper")
    @ApiOperation("添加City")
    public ResultUtil addCity(@RequestBody City city ) {
        int result = cityService.addCity(city);
        if (result>0){
            city.setID(cityService.getID(city.getName()));
            return ResultUtil.ok().data("data",city).message("添加成功");
        }else {
            return ResultUtil.error().message("添加失败");
        }

    }

}
