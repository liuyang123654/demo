package com.example.online_ems.service;

import com.example.online_ems.entity.*;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    UserInfo findall(User user);
    String findid(String id);
    void newuser(NewUser newUser);




}
