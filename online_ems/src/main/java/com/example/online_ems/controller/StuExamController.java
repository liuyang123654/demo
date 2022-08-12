package com.example.online_ems.controller;


import com.example.online_ems.entity.Exam;
import com.example.online_ems.entity.Question;
import com.example.online_ems.entity.StuAnswer;
import com.example.online_ems.service.serviceImpl.StuExamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@RequestMapping("/stuexam")
@Controller

public class StuExamController {

    @Autowired
    private StuExamServiceImpl stuExamService;
    @PostMapping("/seeexamlist")//学生查看自己的考试列表
    @ResponseBody
    public List<Exam> seeexamlist(@RequestBody HashMap<String ,String> map)
    {
        return stuExamService.seeexamlist(map.get("id"));
    }

    @PostMapping("/savescore")//学生提交试卷,前端传过来试题序号和学生答案，后端保存成绩
    @ResponseBody
    public String savescore(@RequestBody StuAnswer stuAnswer)
    {
        //System.out.println(stuAnswer.getAnswerList());
        try{

            if(stuAnswer.getAnswerList()==null)
            {
                System.out.println("答案列表为空");
                return "答案列表为空";
            }
            else{

               int length=stuAnswer.getAnswerList().size();
               int rightanswer=0;//正确答案的个数
               for(int i=0;i<length;i++)
                {
                    String number=stuAnswer.getAnswerList().get(i).getNumber();
                    String answer=stuAnswer.getAnswerList().get(i).getAnswer();
                    Question question=stuExamService.getquestion(number,answer);
                    if(question!=null) rightanswer+=1;//如果能通过题号和学生答案找到题目，说明做对
                }
               int score;
               if (rightanswer==0)  score=0;
               else score=rightanswer*100/length;//计算成绩
                stuExamService.savescore(stuAnswer.getTime(),stuAnswer.getId(),stuAnswer.getCourseid(),score);
                //System.out.println("成绩保存成功,你的成绩是"+score+"分");
                return "成绩保存成功,你的成绩是"+score+"分";
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }

    }
}
