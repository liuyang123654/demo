package com.example.online_ems.service;

import com.example.online_ems.entity.Grade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GradeListService {
    List<Grade> seegradelist(String courseid);
}
