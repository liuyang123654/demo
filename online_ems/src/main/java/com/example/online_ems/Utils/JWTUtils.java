package com.example.online_ems.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {

    private static final String SING = "sxxxcccaaadfehdfuisghgexxe";
    /**
     * 生成token  header.payload.sing
     */
    public static String getToken(Map<String ,String> map){
        Calendar istance = Calendar.getInstance();
        istance.add(Calendar.DATE,1);
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        //        String token = builder
//                .withHeader(map)//header 默认值可以不写
//                .withClaim("userid", 1)//payload
//                .withClaim("username", "psy")
//                .withExpiresAt(istance.getTime())//令牌的过期时间
//                .sign(Algorithm.HMAC256("SING"));
        String token = builder.withExpiresAt(istance.getTime())
                .sign(Algorithm.HMAC256(SING));
        return token;
    }
    /**
     * 验证token 验证合法性  并返回值
     */
    public static DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
    }

}
