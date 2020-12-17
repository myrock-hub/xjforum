package com.xjxy.forum.main.util;

import com.xjforum.home.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: M丶Rock
 * \* Date: 2020/12/17
 * \* Time: 14:16
 * \异常拦截处理器
 */


@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final String logExceptionFormat = "Capture Exception By GlobalExceptionHandler: Code: %s Detail: %s";
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //运行时异常
    @ExceptionHandler(RuntimeException.class)
    public ResultUtil runtimeExceptionHandler(RuntimeException ex) {
        String error = ex.getMessage();
        return resultFormat(2005, error);
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    public ResultUtil nullPointerExceptionHandler(NullPointerException ex) {
        String error= "空指针异常";
        return resultFormat(2003, error);
    }

    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    public ResultUtil classCastExceptionHandler(ClassCastException ex) {
        String error= "类型转换异常";
        return resultFormat(2002, error);
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    public ResultUtil iOExceptionHandler(IOException ex) {
        String error= "IO异常";
        return resultFormat(2006, error);
    }

    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    public ResultUtil noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        String error= "未知方法异常"+ex.getMessage();
        return resultFormat(2007, error);
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResultUtil indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        String error= "数组越界异常";
        return resultFormat(2008, error);
    }

    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResultUtil requestNotReadable(HttpMessageNotReadableException ex) {
        String error= "错误:"+ex.getMessage();
        return resultFormat(400, error);
    }

    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    public ResultUtil requestTypeMismatch(TypeMismatchException ex) {
        String error= "错误:"+ex.getMessage();
        return resultFormat(400, error);
    }

    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ResultUtil requestMissingServletRequest(MissingServletRequestParameterException ex) {
        String error= "错误:"+ex.getMessage();
        return resultFormat(400, error);
    }

    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResultUtil request405(HttpRequestMethodNotSupportedException ex) {
        String error= "错误:"+ex.getMessage();
        return resultFormat(405, error);
    }

    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public ResultUtil request406(HttpMediaTypeNotAcceptableException ex) {
        String error= "错误:"+ex.getMessage();
        return resultFormat(406, error);
    }

    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public ResultUtil server500(RuntimeException ex) {
        String error= "错误:"+ex.getMessage();
        return resultFormat(500, error);
    }

    //栈溢出
    @ExceptionHandler({StackOverflowError.class})
    public ResultUtil requestStackOverflow(StackOverflowError ex) {
        String error= "栈溢出";
        return resultFormat(2009, error);
    }

    //其他错误
    @ExceptionHandler({Exception.class})
    public ResultUtil exception(Exception ex) {
        return resultFormat(2001, "其他错误");
    }

    private <T extends Throwable> ResultUtil resultFormat(Integer code, String error) {
        //ex.printStackTrace();
        log.error(String.format(logExceptionFormat, code, error));
        ResultUtil resultUtil = ResultUtil.error();
        resultUtil.setCode(code);
        resultUtil.setMessage(error);
        return resultUtil;
    }

}
