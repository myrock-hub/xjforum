package com.xjforum.admin.mapper;

import com.xjforum.admin.entity.City;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: M丶Rock
 * \* Date: 2021/1/13
 * \* Time: 13:16
 * \
 */

@Repository
public interface CityMapper {
    City Sel(int id);

    List<City> citySearch(City city);

    int updateCity(City city);

    int deleteCity(String Name);

    int addCity(City city);

    int getID(String Name);

}
