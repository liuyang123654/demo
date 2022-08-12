package com.example.online_ems.service;

import com.example.online_ems.entity.Course;
import com.example.online_ems.entity.NewUser;
import com.example.online_ems.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UseInfoService {
    //更改基本信息
    void userupdate(UserInfo userInfo);

    //添加教师课程
    void addteacourse(String id,String courseid);
    //添加学生课程
    void addstucourse(String id, String courseid,String name);
    //删除教师课程
    void deleteteacourse(String id,String courseid);
    //删除学生课程
    void deletestucourse(String id,String courseid);
    //获取全部课程列表
    List<Course> allcourselist();
}
