package com.example.jwtdemo.demos.pojo.vo;

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
public class UserVo {
    private Long id;
    private String username;
    private String nikename;
    private String avatar;
}
