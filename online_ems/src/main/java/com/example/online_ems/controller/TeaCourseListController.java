package com.example.online_ems.controller;

import java.util.Random;

import com.example.online_ems.entity.Question;
import com.example.online_ems.service.serviceImpl.TeaCourseListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/teacourselist")
public class TeaCourseListController {

    @Autowired
    private TeaCourseListServiceImpl teaCourseListService;



    @PostMapping("/seetestpaper")//教师查看某一科的试卷
    @ResponseBody
    public List<Question> seetestpaper( @RequestBody HashMap<String,String> map)//@RequestParam("courseid") String courseid)
    {
        try{
             return teaCourseListService.seetestpaper(map.get("courseid"));
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/addquestion")
    @ResponseBody
    public String addquestion(@RequestBody Question question)
    {

        String status;
        try{
            //随机生成一个8位的题目编码
            String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            Random random=new Random();
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<8;i++){
                int number=random.nextInt(62);
                sb.append(str.charAt(number));
            }
            question.setNumber(sb.toString());//把前端提交的question的number换成随机生成的编码

            Question question1=teaCourseListService.getquestionbynumber(question.getNumber());//检查一下这个编码是不是在库里
            if(question1!=null) status="已有题目，请勿重复添加";
            else{
                teaCourseListService.addquestion(question);
                status="添加成功";
            }
        }catch(Exception e){
            e.printStackTrace();
            status=e.getMessage();
        }
        //System.out.println(status);
        return status;
    }

    @PostMapping("/deletequestion")
    @ResponseBody
    public String deletequestion(@RequestBody HashMap<String,String> map)
    {
        String status;
        try{
            teaCourseListService.deletequestion(map.get("number"));
            status="删除成功";
        }catch(Exception e){
            e.printStackTrace();
            status=e.getMessage();
        }
        return status;
    }

    @PostMapping("/updatequestion")
    @ResponseBody
    public String updatequestion(@RequestBody Question question)
    {
        String status;
        try{
            teaCourseListService.updatequestion(question);
            status="修改成功";
        }catch(Exception e){
            e.printStackTrace();
            status=e.getMessage();
         }
        return status;
    }
}
