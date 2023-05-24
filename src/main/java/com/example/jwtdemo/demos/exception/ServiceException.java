package com.example.jwtdemo.demos.exception;

import com.example.jwtdemo.demos.pojo.ResultCode;
import lombok.Getter;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author car
 * @create 2023/5/23
 */

@Getter
public class ServiceException extends RuntimeException{
    private final Integer code;

    public ServiceException(ResultCode resultCode){
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
    }

}
