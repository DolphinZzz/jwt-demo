package com.example.jwtdemo.demos.pojo;

import lombok.Getter;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author car
 * @create 2023/5/23
 */
@Getter
public enum ResultCode {
    SYSTEM_FAILURE(400,"系统错误"),
    LOGIN_SUCCESS(200,"登陆成功"),
    RETURN_SUCCESS(200,"返回成功"),
    RESULT_FAILURE(404,"返回失败"),
    LOGIN_NOTLOGIN(401,"未登录"),
    LOGIN_EXPIRATION(402,"登录已过期"),
    LOGIN_ACCOUNT_PWD_NOT_ERROR(403, "账号或密码错误");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
