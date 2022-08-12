package com.example.online_ems.dao;


import com.example.online_ems.entity.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GradeListDao {
    List<Grade> seegradelist(@Param("courseid") String courseid);

}
