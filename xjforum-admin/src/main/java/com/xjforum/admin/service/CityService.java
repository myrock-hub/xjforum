package com.xjforum.admin.service;

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



}
