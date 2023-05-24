package com.example.jwtdemo.demos.utils;

import com.example.jwtdemo.demos.exception.ServiceException;
import com.example.jwtdemo.demos.pojo.ResultCode;
import com.example.jwtdemo.demos.pojo.dto.UserDTO;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author car
 * @create 2023/5/23
 */
@Slf4j
public class JwtTokenUtil {
    /**
     * 请求头
     */
    public static final String TOKEN_PREFIX = "Authorization";
    /**
     * base64的密钥
     */
    private static final String base64Secret = "and0LWRlbW8=";
    /**
     * 过期时间
     */
    private static final long expire = 60000L;

    public static String createJWT(UserDTO userDTO){
        try {
            // 生成签名密钥
            byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Secret);
            Key signingKey = new SecretKeySpec(apiKeySecretBytes,  SignatureAlgorithm.HS256.getJcaName());

            return Jwts.builder()
                    // header
                    .setHeaderParam("typ", "JWT")
                    .setHeaderParam("alg","256")
                    // payload
                    .claim("id",userDTO.getId())
                    .claim("username",userDTO.getUsername())
                    .claim("avatar",userDTO.getAvatar())
                    //  是一个时间戳，代表这个JWT的签发时间
                    .setIssuedAt(new Date())
                    // 是一个时间戳，代表这个JWT生效的开始时间，意味着在这个时间之前验证JWT是会失败的
                    .setNotBefore(new Date(System.currentTimeMillis()))
                    // 是一个时间戳，代表这个JWT的过期时间
                    .setExpiration(new Date(System.currentTimeMillis()+expire))
                    // 签名
                    .signWith(SignatureAlgorithm.HS256,signingKey)
                    .compact();
        } catch (Exception e) {
            log.error("签名失败",e);
            throw new ServiceException(ResultCode.SYSTEM_FAILURE);
        }
    }

    public static Claims parseJWT(String token){
        try {
            return Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Secret))
                    .parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            log.error("===== Token过期 =====", e);
            throw new ServiceException(ResultCode.SYSTEM_FAILURE);
        } catch (Exception e) {
            log.error("===== Token解析异常 =====", e);
            throw new ServiceException(ResultCode.SYSTEM_FAILURE);
        }
    }

    /**
     * 判断token是否过期
     * @param token
     * @return
     */
    public static boolean isExpiration(String token){
        return parseJWT(token).getExpiration().before(new Date());
    }
}

