package com.example.online_ems.controller;

import com.example.online_ems.entity.Grade;
import com.example.online_ems.service.serviceImpl.GradeListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@RequestMapping("/gradelist")
@Controller
public class GradeListController {
    @Autowired
     GradeListServiceImpl gradeListService;
    @PostMapping("/seegradelist")//教师查看某一科学生的成绩列表
    @ResponseBody
    //@responseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML
    public List<Grade> seegradelist(@RequestBody HashMap<String,String> map)
    {
        //System.out.println("学生成绩列表:" + gradeListService.seegradelist(map.get("courseid")));
        return gradeListService.seegradelist(map.get("courseid"));
    }
}
