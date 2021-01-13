package com.xjxy.forum.main.util;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: M丶Rock
 * \* Date: 2020/12/17
 * \* Time: 13:13
 * \
 */

@Data
@ApiModel(value = "返回结果")
public class ResultUtil {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;
    @ApiModelProperty(value = "状态码")
    private Integer code;
    @ApiModelProperty(value = "返回信息")
    private String message;
    @ApiModelProperty(value = "结果")
    private Map<String, Object> data = new HashMap<>();

    /**
     * 构造器私有
     */
    public ResultUtil() {
    }

    /**
     * 通用返回成功
     */
    public static ResultUtil ok() {
        ResultUtil r = new ResultUtil();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }

    /**
     * 通用返回失败，未知错误
     *
     * @return
     */
    public static ResultUtil error() {
        ResultUtil r = new ResultUtil();
        r.setSuccess(ResultCodeEnum.UNKNOWN_ERROR.getSuccess());
        r.setCode(ResultCodeEnum.UNKNOWN_ERROR.getCode());
        r.setMessage(ResultCodeEnum.UNKNOWN_ERROR.getMessage());
        return r;
    }

    /**
     * 设置结果，形参为结果枚举
     *
     * @param result
     * @return
     */
    public static ResultUtil setResult(ResultCodeEnum result) {
        ResultUtil r = new ResultUtil();
        r.setSuccess(result.getSuccess());
        r.setCode(result.getCode());
        r.setMessage(result.getMessage());
        return r;
    }

    /**
     * ------------使用链式编程，返回类本身----------
     * 自定义返回数据
     *
     * @param map
     * @return
     */
    public ResultUtil data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

    /**
     * 通用设置data
     *
     * @param key
     * @param value
     * @return
     */
    public ResultUtil data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    /**
     * 自定义状态信息
     *
     * @param message
     * @return
     */
    public ResultUtil message(String message) {
        this.setMessage(message);
        return this;
    }

    /**
     * 自定义状态码
     *
     * @param code
     * @return
     */
    public ResultUtil code(Integer code) {
        this.setCode(code);
        return this;
    }

    /**
     * 自定义返回结果
     *
     * @param success
     * @return
     */
    public ResultUtil success(Boolean success) {
        this.setSuccess(success);
        return this;
    }


}
