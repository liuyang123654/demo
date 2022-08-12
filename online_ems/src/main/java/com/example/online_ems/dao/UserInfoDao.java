package com.example.online_ems.dao;

import com.example.online_ems.entity.Course;
import com.example.online_ems.entity.NewUser;
import com.example.online_ems.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoDao {
    void userupdate(UserInfo userInfo);//更改基本信息
    //添加教师课程
    void addteacourse(@Param("id") String id,@Param("courseid") String courseid);
    //添加学生课程
    void addstucourse(@Param("id") String id,@Param("courseid") String courseid,@Param("name") String name);
    //删除教师课程
    void deleteteacourse(@Param("id") String id,@Param("courseid") String courseid);
    //删除学生课程
    void deletestucourse(@Param("id") String id,@Param("courseid") String courseid);

    List<Course> allcourselist();
}
