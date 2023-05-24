package com.example.jwtdemo.demos.controller;

import com.example.jwtdemo.demos.entity.User;
import com.example.jwtdemo.demos.pojo.ApiResult;
import com.example.jwtdemo.demos.pojo.ResultCode;
import com.example.jwtdemo.demos.pojo.dto.UserDTO;
import com.example.jwtdemo.demos.pojo.vo.UserVo;
import com.example.jwtdemo.demos.utils.JwtTokenUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author car
 * @create 2023/5/23
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    private static User user = new User().setId(1L).setUsername("admin").setNikename("admin").setPassword("admin").setAvatar("https://www.baidu.com");

    @PostMapping("/login")
    public ApiResult<Map<String,Object>> login(@RequestBody UserDTO userDTO) {
        String token = JwtTokenUtil.createJWT(userDTO);
        Map<String,Object> info = new HashMap<>();
        info.put("id",user.getId());
        info.put("username",user.getUsername());
        info.put("avatar",user.getAvatar());
        info.put("token", token);
        return ApiResult.success(ResultCode.LOGIN_SUCCESS, info);
    }

    /**
     * 测试 携带token并且token没有过期才能访问到此接口
     * @return
     */
    @GetMapping("/list")
    public ApiResult<UserVo> getUserInfo(){
        UserVo userVo = new UserVo().setId(user.getId()).setUsername(user.getUsername()).setNikename(user.getNikename()).setAvatar(user.getAvatar());
        return ApiResult.success(ResultCode.RETURN_SUCCESS,userVo);
    }

}
