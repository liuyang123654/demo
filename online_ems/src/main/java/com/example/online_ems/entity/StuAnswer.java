package com.example.online_ems.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StuAnswer {
    String courseid;
    String id;
    String time;
    List<EachAnswer> answerList;

}
