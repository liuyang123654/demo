package com.example.online_ems.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserInfo {
    private String name;
    private String sex;
    private String phone;
    private String id;
    private String college;
    private String password;
    private int type;
    private List<Course> courses;

}
