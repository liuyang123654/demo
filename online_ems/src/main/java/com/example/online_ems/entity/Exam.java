package com.example.online_ems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Exam {
    private String courseid;
    private String coursename;
    private int lastgrade;
    private int examnumber;
    private String date;

}
