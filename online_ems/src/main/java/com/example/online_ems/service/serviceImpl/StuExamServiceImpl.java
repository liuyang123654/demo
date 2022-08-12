package com.example.online_ems.service.serviceImpl;

import com.example.online_ems.dao.StuExamDao;
import com.example.online_ems.entity.Exam;
import com.example.online_ems.entity.Question;
import com.example.online_ems.service.StuExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuExamServiceImpl implements StuExamService {
    @Autowired
    private StuExamDao stuExamDao;

    @Override
    public List<Exam> seeexamlist(String id) {
        return stuExamDao.seeexamlist(id);
    }

    @Override
    public void savescore(String time, String id, String courseid, int score) {
        stuExamDao.savescore(time,id,courseid,score);
    }

    @Override
    public Question getquestion(String number, String answer) {
        return stuExamDao.getquestion(number,answer);
    }
}
