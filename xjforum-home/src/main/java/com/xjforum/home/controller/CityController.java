package com.xjforum.home.controller;

import com.xjforum.home.entity.City;
import com.xjforum.home.entity.CityParam;
import com.xjforum.home.service.CityServiceImpl;
import com.xjforum.home.util.ResultUtil;
import com.xxl.job.core.handler.annotation.JobHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController("/city")
@Api(tags = {"城市controller"})
public class CityController {
    @Autowired
    CityServiceImpl cityService;

    @ApiOperation(value = "按id查询城市信息")
    @GetMapping("/queryCityList")
    public ResultUtil queryCityList(@RequestParam("id") int id) {
        List<City> queryCityList = cityService.queryCityList(id);
        return ResultUtil.ok().data("data", queryCityList).message("城市列表");

    }

    @ApiOperation(value = "查询全部城市信息")
    @ResponseBody
    @GetMapping("/findAllByPage")
    public ResultUtil findAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        Page<City> cityList = cityService.findAlllist(page, size);
        return ResultUtil.ok().data("data", cityList).message("分页查看城市信息");
    }

    @ApiOperation(value = "添加城市")
    @ResponseBody
    @PostMapping("/saveCity")
    public ResultUtil save(@RequestBody City city) {
        String save = cityService.save(city);
        return ResultUtil.ok().data("data", save);
    }

    @ApiOperation(value = "删除城市")
    @ResponseBody
    @PostMapping("/deleteCity")
    public ResultUtil deleteCity(@RequestParam("name") String name) {
        City city = new City();
        city.setName(name);
        String delete = cityService.delete(city);
        return ResultUtil.ok().data("data", delete);
    }

    @ApiOperation(value = "修改城市信息")
    @ResponseBody
    @PostMapping("/updateCity")
    public ResultUtil updateCity(@RequestBody City city) {
        String update = cityService.updateCity(city);
        return ResultUtil.ok().data("data", update);
    }

    @ApiOperation(value = "关键字查询城市信息")
    @ResponseBody
    @PostMapping("/findAllByKeyWord")
    public ResultUtil findAllByKeyWord(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestBody CityParam cityParam) {
        Page<City> cityList = cityService.findAllByKeyWord(page, size, cityParam);
        return ResultUtil.ok().data("data", cityList).message("关键字查询城市信息");
    }


    @ApiOperation(value = "多选删除城市信息")
    @ResponseBody
    @PostMapping("/deleteBatch")
    public ResultUtil deleteBatch(
            @RequestBody String[] names) {
        List<String> name = new ArrayList<String>(Arrays.asList(names));
        int i = cityService.deleteBatch(name);
        if (i > 0) {
            return ResultUtil.ok().data("data", "成功删除" + i + "条数据").message("多选删除城市信息");
        } else {
            return ResultUtil.error().data("dara", "删除失败：" + i).message("多选删除城市信息");
        }

    }


}
