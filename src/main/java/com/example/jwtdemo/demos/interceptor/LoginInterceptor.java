package com.example.jwtdemo.demos.interceptor;

import cn.hutool.core.util.StrUtil;
import com.example.jwtdemo.demos.entity.User;
import com.example.jwtdemo.demos.exception.ServiceException;
import com.example.jwtdemo.demos.pojo.ResultCode;
import com.example.jwtdemo.demos.pojo.dto.UserDTO;
import com.example.jwtdemo.demos.pojo.vo.UserVo;
import com.example.jwtdemo.demos.utils.JwtTokenUtil;
import com.example.jwtdemo.demos.utils.UserHolder;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author car
 * @create 2023/5/24
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求头信息
        String header = request.getHeader(JwtTokenUtil.TOKEN_PREFIX);
        if(StrUtil.isBlank(header)){
            log.info("用户未登录");
            throw new ServiceException(ResultCode.LOGIN_NOTLOGIN);
        }
        try {
            // 解析token中的信息
            Claims claims = JwtTokenUtil.parseJWT(header);
            // 将解析信息放入ThreadLocal
            User user = new User().setUsername((String) claims.get("username"))
                    .setId((Long) claims.get("id"))
                    .setAvatar((String) claims.get("avatar"));
            UserHolder.put(user);
        } catch (Exception e) {
            throw new ServiceException(ResultCode.LOGIN_EXPIRATION);
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserHolder.remove();
    }
}
