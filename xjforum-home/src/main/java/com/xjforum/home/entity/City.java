package com.xjforum.home.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "city")
public class City implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @Getter
    @Setter
    private int ID;
    @Column(name = "Name")
    @ApiModelProperty(value = "城市名字", dataType = "String", name = "name", example = "Kabul")
    @Getter
    @Setter
    private String Name;

    @Column(name = "Countrycode")
    @Getter
    @Setter
    @ApiModelProperty(value = "城市编码", dataType = "String", name = "Countrycode", example = "AFG")
    private String CountryCode;

    @Column(name = "District")
    @Getter
    @Setter
    @ApiModelProperty(value = "省", dataType = "String", name = "District", example = "Qandahar")
    private String District;
    @Column(name = "Population")
    @Getter
    @Setter
    @ApiModelProperty(value = "城市人口", dataType = "int", name = "Population", example = "1780000")
    private int Population;


}
