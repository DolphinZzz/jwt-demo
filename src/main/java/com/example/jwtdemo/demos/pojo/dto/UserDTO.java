package com.example.jwtdemo.demos.pojo.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author car
 * @create 2023/5/23
 */
@Data
@Accessors(chain = true)
public class UserDTO {
    private String id;
    private String username;
    private String password;
    private String avatar;
    private String captcha;
}
