package com.example.jwtdemo.demos.utils;

import com.example.jwtdemo.demos.entity.User;
import com.example.jwtdemo.demos.pojo.dto.UserDTO;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author car
 * @create 2023/5/24
 */
public class UserHolder {
    private static final ThreadLocal<User> LOCAL =  new ThreadLocal<>();

    public static void put(User user){
        LOCAL.set(user);
    }

    public static User get(){
        return LOCAL.get();
    }

    public static void remove(){
        LOCAL.remove();
    }
}
