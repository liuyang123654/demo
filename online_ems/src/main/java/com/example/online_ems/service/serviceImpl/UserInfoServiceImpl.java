package com.example.online_ems.service.serviceImpl;


import com.example.online_ems.dao.UserInfoDao;
import com.example.online_ems.entity.Course;
import com.example.online_ems.entity.NewUser;
import com.example.online_ems.entity.UserInfo;
import com.example.online_ems.service.UseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UseInfoService{

    @Autowired
    private UserInfoDao userInfoDao;
    @Override
    public void userupdate(UserInfo userInfo) {
        userInfoDao.userupdate(userInfo);
    }

    @Override
    public void addteacourse(String id, String courseid) {
        userInfoDao.addteacourse(id,courseid);
    }

    @Override
    public void addstucourse(String id, String courseid,String name) {
        userInfoDao.addstucourse(id,courseid,name);
    }

    @Override
    public void deleteteacourse(String id, String courseid) {
        userInfoDao.deleteteacourse(id,courseid);
    }

    @Override
    public void deletestucourse(String id, String courseid) {
        userInfoDao.deletestucourse(id,courseid);
    }

    @Override
    public List<Course> allcourselist() {
        return userInfoDao.allcourselist();
    }
}
