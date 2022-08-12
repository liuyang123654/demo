package com.example.online_ems.Interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.online_ems.Utils.JWTUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String,Object> map = new HashMap<>();
        String token = request.getHeader("token");//获取请求头中的令牌
        try{
            JWTUtils.verify(token);
            map.put("state",true);
            map.put("msg","请求成功");
            return true;
        }catch (SignatureVerificationException e){
            e.printStackTrace();
            map.put("msg","无效签名！");
        }catch (TokenExpiredException e){
            e.printStackTrace();
            map.put("msg","token过期！");

        }catch (AlgorithmMismatchException e){
            e.printStackTrace();
            map.put("msg","token算法不一致！");

        } catch (Exception e){
            e.printStackTrace();
            map.put("msg","token无效！");

        }
        map.put("state",false);//设置状态
        //将map  转换json jackson
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }

}
