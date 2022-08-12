package com.example.online_ems.dao;

import com.example.online_ems.entity.Exam;
import com.example.online_ems.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StuExamDao{
    List<Exam> seeexamlist(String id);
    void savescore(@Param("time") String time,@Param("id") String id, @Param("courseid") String courseid, @Param("score") int score);
    Question getquestion(@Param("number") String number,@Param("answer") String answer);
}
