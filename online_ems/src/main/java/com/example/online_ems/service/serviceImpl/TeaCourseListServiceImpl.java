package com.example.online_ems.service.serviceImpl;

import com.example.online_ems.dao.TeaCourseListDao;
import com.example.online_ems.entity.Question;
import com.example.online_ems.service.TeaCourseListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeaCourseListServiceImpl implements TeaCourseListService {

    @Autowired
    private TeaCourseListDao teaCourseListDao;

    @Override
    public List<Question> seetestpaper(String courseid) {
        return teaCourseListDao.seetestpaper(courseid);
    }

    @Override
    public Question getquestionbynumber(String number) {
        return teaCourseListDao.getquestionbynumber(number);
    }

    @Override
    public void addquestion(Question question) {
        teaCourseListDao.addquestion(question);
    }

    @Override
    public void deletequestion(String number) {
        teaCourseListDao.deletequestion(number);
    }

    @Override
    public void updatequestion(Question question) {
        teaCourseListDao.updatequestion(question);
    }

}
