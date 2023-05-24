package com.example.jwtdemo.demos.pojo;

import lombok.Data;
import lombok.Getter;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author car
 * @create 2023/5/23
 */
@Data
@Getter
public class ApiResult<T> {
    private Integer code;
    private String message;
    private T data;

    public ApiResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> ApiResult<T> error(ResultCode resultCode){
        return error(resultCode.getCode(),resultCode.getMessage());
    }
    public static <T> ApiResult<T> error(Integer code,String message){
        return new ApiResult<>(code,message);
    }

    public static <T> ApiResult<T> success(ResultCode resultCode,T data){
        return success(resultCode.getCode(),resultCode.getMessage(),data);
    }
    public static <T> ApiResult<T> success(Integer code,String message,T data){
        return new ApiResult<>(code,message,data);
    }
}
