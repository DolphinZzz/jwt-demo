package com.example.jwtdemo.demos.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author car
 * @create 2023/5/23
 */
@Data
@Accessors(chain = true)
public class User {
    /**
     * 编码
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nikename;
    /**
     * 备注
     */
    private String remark;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话
     */
    private String mobile;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 创建日期
     */
    private LocalDateTime create_time;
    /**
     * 更新日期
     */
    private LocalDateTime update_time;
    /**
     * 状态
     */
    private Integer status;
}
