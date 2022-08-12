package com.example.online_ems.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    private String name;
    private String coursename;
    private int lastgrade;
    private List<GradeSituation> list;
}
