package com.example.online_ems;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@MapperScan("com.example.online_ems.dao")
public class OnlineEmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineEmsApplication.class, args);
    }

}
