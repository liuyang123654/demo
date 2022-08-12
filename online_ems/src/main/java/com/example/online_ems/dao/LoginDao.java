package com.example.online_ems.dao;


import com.example.online_ems.entity.*;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface LoginDao {
   UserInfo findall(User user);
   String findid(String id);
   void newuser(NewUser newUser);

}
