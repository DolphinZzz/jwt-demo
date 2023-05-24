package com.example.jwtdemo.demos.exception;

import com.example.jwtdemo.demos.pojo.ApiResult;
import com.example.jwtdemo.demos.pojo.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author car
 * @create 2023/5/23
 */
@Slf4j
@ControllerAdvice("com.example.jwtdemo.demos.controller")
public class GlobalExceptionHandler {
    /**
     * 自定义异常
     * @param request
     * @param exception
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = ServiceException.class)
    public ApiResult serviceExceptionHandler(HttpServletRequest request,ServiceException exception){
        log.info("[serviceExceptionHandler]",exception);
        return ApiResult.error(exception.getCode(),exception.getMessage());
    }
    /**
     * 兜底异常
     * @param request
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ApiResult exceptionHandler(HttpServletRequest request,Exception e){
        log.info("[exceptionHandler]",e);
        return ApiResult.error(ResultCode.SYSTEM_FAILURE.getCode(), ResultCode.SYSTEM_FAILURE.getMessage());
    }
}
