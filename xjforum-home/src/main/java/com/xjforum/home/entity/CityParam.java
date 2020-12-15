package com.xjforum.home.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: admin
 * \* Date: 2020/12/14
 * \* Time: 16:57
 * \
 */


public class CityParam {

    private String Name;
    private String CountryCode;
    private String District;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }
}
