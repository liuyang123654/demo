package com.example.online_ems.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewUser {
    private int type;
    private String name;
    private String id;
    private String password;
    private String sex;
    private String phone;
    private String college;
}
