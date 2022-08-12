package com.example.online_ems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Question {
    private String courseid;//科目
    private String number;//唯一标识
    private int value;//分值
    private String stem;//题干
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;
}
