package com.example.online_ems.controller;

import com.example.online_ems.Utils.JWTUtils;
import com.example.online_ems.entity.*;
import com.example.online_ems.service.serviceImpl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RequestMapping("/login")
@Controller

public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> login( @RequestBody User user)
    {
        UserInfo userInfo=loginService.findall(user);
        //System.out.println(userInfo);
        Map<String,Object> map=new HashMap<>();
        try{
            if(userInfo==null) {
                map.put("state",false);
                map.put("msg","学工号或密码不正确");
            }else{
                    Map<String,String> payload=new HashMap<>();
                    payload.put("id",user.getId());
                    payload.put("password",user.getPassword());
                    String token= JWTUtils.getToken(payload);
                    map.put("token",token);
                map.put("state",true);
                map.put("msg","登录成功");
                map.put("user",userInfo);
            }
        }catch (Exception e)
        {
            map.put("state",false);
            map.put("msg",e.getMessage());
        }
        //System.out.println(map);
        return map;
    }


    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestBody NewUser newUser) {

               String id=loginService.findid(newUser.getId());
               if (id == null) {
                    loginService.newuser(newUser);
                    if(newUser.getType()==1)
                    {
                        //System.out.println("注册学生账号成功");
                        return "注册学生账号成功";
                    } else{
                        //System.out.println("注册教师账号成功");
                        return "注册教师账号成功";}
                }

                else {
                    if(newUser.getType()==1)
                    {
                        //System.out.println("已有学生账号，请登录");
                        return "已有学生账号，请登录";
                    }
                    else{
                        //System.out.println("已有教师账号，请登录");
                        return "已有教师账号，请登录";
                    }
                }

        }

}


