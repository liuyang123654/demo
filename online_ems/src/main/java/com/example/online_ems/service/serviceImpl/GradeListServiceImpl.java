package com.example.online_ems.service.serviceImpl;

import com.example.online_ems.dao.GradeListDao;
import com.example.online_ems.entity.Grade;
import com.example.online_ems.service.GradeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeListServiceImpl implements GradeListService {
    @Autowired
    private GradeListDao gradeListDao;
    @Override
    public List<Grade> seegradelist(String courseid) {
        return gradeListDao.seegradelist(courseid);
    }
}
