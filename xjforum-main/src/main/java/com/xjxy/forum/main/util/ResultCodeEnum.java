package com.xjxy.forum.main.util;

import lombok.Getter;


/**
 * 自定返回枚举类型
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(true,2000,"成功"),
    UNKNOWN_ERROR(false,2001,"未知错误"),
    PARAM_ERROR(false,2002,"参数错误"),
    NULL_POINT(false,2003,"空指针异常"),
    HTTP_CLIENT_ERROR(false,2004,"客户端连接异常"),;


    /**
     * 响应是否成功
     */
    private Boolean success;
    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String message;

    ResultCodeEnum(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

}
