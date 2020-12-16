package com.xjforum.home.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "city")
public class City implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")

    private int ID;
    @Column(name = "Name")
    @ApiModelProperty(value = "城市名字", dataType = "String", name = "name", example = "Kabul")

    private String Name;

    @Column(name = "Countrycode")
    @ApiModelProperty(value = "城市编码", dataType = "String", name = "Countrycode", example = "AFG")
    private String CountryCode;

    @Column(name = "District")
    @ApiModelProperty(value = "省", dataType = "String", name = "District", example = "Qandahar")
    private String District;
    @Column(name = "Population")
    @ApiModelProperty(value = "城市人口", dataType = "int", name = "Population", example = "1780000")
    private int Population;


}
