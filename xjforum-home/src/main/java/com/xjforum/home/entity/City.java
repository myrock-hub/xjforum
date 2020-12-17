package com.xjforum.home.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "city")
@ApiModel(value = "城市")
public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int ID;

    @ApiModelProperty(value = "城市名")
    @Column(name = "Name")
    private String Name;

    @ApiModelProperty(value = "城市编码")
    @Column(name = "Countrycode")
    private String CountryCode;

    @ApiModelProperty(value = "省")
    @Column(name = "District")
    private String District;

    @ApiModelProperty(value = "城市人口")
    @Column(name = "Population")
    private int Population;


}
