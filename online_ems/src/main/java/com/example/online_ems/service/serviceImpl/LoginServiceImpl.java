package com.example.online_ems.service.serviceImpl;

import com.example.online_ems.dao.LoginDao;
import com.example.online_ems.entity.*;
import com.example.online_ems.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;


    @Override
    public UserInfo findall(User user) {
        return loginDao.findall(user);
    }

    @Override
    public String findid(String id) {
        return loginDao.findid(id);
    }

    @Override
    public void newuser(NewUser newUser) {
        loginDao.newuser(newUser);
    }

}
