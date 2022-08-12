package com.example.online_ems.controller;
import com.example.online_ems.entity.Course;
import com.example.online_ems.entity.User;
import com.example.online_ems.entity.UserInfo;
import com.example.online_ems.service.serviceImpl.LoginServiceImpl;
import com.example.online_ems.service.serviceImpl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoServiceImpl userInfoService;
    @Autowired
    private LoginServiceImpl loginService;


    @PostMapping("/userupdate")
    @ResponseBody
    public String  userupdate(@RequestBody UserInfo userInfo)
    {

        String status;
        try{
            userInfoService.userupdate(userInfo);//修改除课程之外的其他数据
            //System.out.println("新数据"+userInfo);
            if(userInfo.getType()==0)//类型是老师(type=0代表老师，1代表学生)
            {
                User user=new User(userInfo.getType(),userInfo.getId(),userInfo.getPassword());
                UserInfo userInfo1=loginService.findall(user);//找到原来的课程

                List<Course> list1=userInfo1.getCourses();//原来的课程
                //System.out.println("list1="+list1);
                List<Course> list2=userInfo.getCourses();//现在的课程
                //System.out.println("list2="+list2);
                if(list1.size()!=0)//删掉原来的课程
                    for(int i=0;i<list1.size();i++)
                    {
                        userInfoService.deleteteacourse(userInfo1.getId(),list1.get(i).getCourseid());
                        //System.out.println("正在删除：id="+userInfo1.getId()+"courseid="+list1.get(i).getCourseid());
                    }
                if(list2.size()!=0)//加上新课程
                    for(int i=0;i<list2.size();i++)
                    {
                        userInfoService.addteacourse(userInfo1.getId(),list2.get(i).getCourseid());
                        //System.out.println("正在添加：id="+userInfo1.getId()+";courseid="+list2.get(i).getCourseid());

                    }
                status="修改成功";
            }else{//类型是学生

                    User user=new User(userInfo.getType(),userInfo.getId(),userInfo.getPassword());
                    UserInfo userInfo1=loginService.findall(user);//包含用户信息的一个对象(课程还没有修改)
                    List<Course> list1=userInfo1.getCourses();//原来的课程
                    List<Course> list2=userInfo.getCourses();//现在的课程

                //备份list1
                    List<Course> list3=new ArrayList<>();
                    list3.addAll(list1);
                    if(list1.size()!=0)
                    {
                        list1.removeAll(list2);
                        if(list1.size()!=0)
                        {
                            for(int i=0;i< list1.size();i++)
                                userInfoService.deletestucourse(userInfo1.getId(),list1.get(i).getCourseid());
                        }
                    }
                   list2.removeAll(list3);
                   if(list2.size()!=0)
                        for(int i=0;i<list2.size();i++)
                        {
                            userInfoService.addstucourse(userInfo1.getId(),list2.get(i).getCourseid(),userInfo1.getName());
                        }
                status="修改成功";
            }

        }catch(Exception e){
            e.printStackTrace();
            status=e.getMessage();
        }
        return status;
    }

    @GetMapping("/allcourselist")//查看所有课程(用于修改个人信息的时候添加课程)
    @ResponseBody
    public List<Course> allcourselist()
    {
        return userInfoService.allcourselist();
    }
}
