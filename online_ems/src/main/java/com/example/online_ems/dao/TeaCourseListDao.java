package com.example.online_ems.dao;

import com.example.online_ems.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeaCourseListDao {
   List<Question> seetestpaper(String courseid);
   Question getquestionbynumber(String number);
   void addquestion(Question question);
   void deletequestion(String number);
   void updatequestion(Question question);
}

