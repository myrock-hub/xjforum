package com.xjforum.home.controller;

import com.xjforum.home.entity.City;
import com.xjforum.home.entity.CityParam;
import com.xjforum.home.service.CityServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;


import java.util.List;

@RestController("/city")
public class CityController {
    @Autowired
    CityServiceImpl cityService;

    @ApiOperation(value="按id查询城市信息")
    @ResponseBody
    @GetMapping("/queryCityList")
    public String queryCityList(@RequestParam("id") int id)  {
        List<City> queryCityList = cityService.queryCityList(id);
        String jsonString = JSON.toJSONString(queryCityList);
        return  jsonString;

    }

    @ApiOperation(value="查询全部城市信息")
    @ResponseBody
    @GetMapping("/findAllByPage")
    public String findAll(@RequestParam("page") int page,@RequestParam("size") int size)  {
        Page<City> cityList = cityService.findAlllist(page,size);
        String jsonString = JSON.toJSONString(cityList);
        return  jsonString;
    }

    @ApiOperation(value = "添加城市")
    @ResponseBody
    @PostMapping("/saveCity")
    public String save(@RequestBody City city){
        String save = cityService.save(city);
        return save;
    }

    @ApiOperation(value = "删除城市")
    @ResponseBody
    @PostMapping("/deleteCity")
    public String deleteCity(@RequestParam("name") String name){
        City city = new City();
        city.setName(name);
        String delete = cityService.delete(city);
        return delete;
    }

    @ApiOperation(value = "修改城市信息")
    @ResponseBody
    @PostMapping("/updateCity")
    public String updateCity(@RequestBody City city){
        String update = cityService.updateCity(city);
        return update;
    }

    @ApiOperation(value="关键字查询城市信息")
    @ResponseBody
    @PostMapping("/findAllByKeyWord")
    public String findAllByKeyWord(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestBody CityParam cityParam)  {
        Page<City> cityList = cityService.findAllByKeyWord(page, size,cityParam);
        String jsonString = JSON.toJSONString(cityList);
        return  jsonString;
    }
}
