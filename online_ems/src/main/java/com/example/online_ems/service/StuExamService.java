package com.example.online_ems.service;

import com.example.online_ems.entity.Exam;
import com.example.online_ems.entity.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StuExamService {
    List<Exam> seeexamlist(String id);
    void savescore(String time,String id, String courseid, int score);
    Question getquestion( String number, String answer);
}
