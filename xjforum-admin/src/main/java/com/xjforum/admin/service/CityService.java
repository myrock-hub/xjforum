package com.xjforum.admin.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xjforum.admin.entity.City;
import com.xjforum.admin.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * \* Created with IntelliJ IDEA.
 * \* User: M丶Rock
 * \* Date: 2021/1/13
 * \* Time: 13:20
 * \
 */

@Service
public class CityService {
    @Autowired
    CityMapper cityMapper;

    public City Sel(int id){
        return cityMapper.Sel(id);
    }

    public int getID(String Name){
        return cityMapper.getID(Name);
    }

    public PageInfo<City> citySearch(City city , int page, int size ){
        PageHelper.startPage(page,size);
        return new PageInfo<>( cityMapper.citySearch(city));
    }

    public int updateCity(City city ){
        return cityMapper.updateCity(city);
    }

    public int deleteCity(String Name){
        return cityMapper.deleteCity(Name);
    }

    public int addCity(City city ){
        return cityMapper.addCity(city);
    }


}
