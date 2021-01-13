package com.xjforum.admin.mapper;

import com.xjforum.admin.entity.City;
import org.springframework.stereotype.Repository;

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
}
