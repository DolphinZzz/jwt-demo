package com.example.jwtdemo;

import com.example.jwtdemo.demos.pojo.dto.UserDTO;
import com.example.jwtdemo.demos.utils.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author car
 * @create 2023/5/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JwtDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class jwtTest {
    @Test
    public void testJwt(){
        String token = JwtTokenUtil.createJWT(new UserDTO().setId("1").setUsername("user").setAvatar("http://www.baidu.com"));
        System.out.println(token);
//        Claims claims = JwtTokenUtil.parseJWT(token);
//        System.out.println(claims);
        String expireToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IjEiLCJ1c2VybmFtZSI6InVzZXIiLCJhdmF0YXIiOiJodHRwOi8vd3d3LmJhaWR1LmNvbSIsImlhdCI6MTY4NDg5MjYxNCwibmJmIjoxNjg0ODkyNjE0LCJleHAiOjE2ODQ4OTI2NzR9._FdfIGEUbzNSHS4Wo6l50MsjkODCpvE7dLGJMCP4JSM";
        boolean expiration = JwtTokenUtil.isExpiration(expireToken);
        System.out.println(expiration);
    }
}
