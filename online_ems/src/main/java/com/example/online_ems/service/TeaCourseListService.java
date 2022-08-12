package com.example.online_ems.service;

import com.example.online_ems.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeaCourseListService {
    List<Question> seetestpaper(String courseid);
    Question getquestionbynumber(String number);
    void addquestion(Question question);
    void deletequestion(String number);
    void updatequestion(Question question);
}
