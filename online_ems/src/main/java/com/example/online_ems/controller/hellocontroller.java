package com.example.online_ems.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class hellocontroller {

    @GetMapping("/world")
    public String hello()
    {
        System.out.println("helloworld");
        return "hello!!!";
    }
}
