package com.ani.spring.controller;

import com.ani.spring.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CustomerController {

    @Value("${cust.age.msg}")
    private String ageMsg;

    @Autowired
    private Environment env;

    // 👉 customer controller is dependent on date util

//    @Autowired // ✅ field level injection
//    @Qualifier("rev2")
    private DateUtil util;

//    @Autowired // ✅ constructor injection
//    public CustomerController(@Qualifier("rev2") DateUtil util) {
//        this.util = util;
//    }

    @Autowired // ✅ setter injection
    public void setUtil(DateUtil util) {
        this.util = util;
    }

    public void calculateAge() {
        long age = util.diffFromToday(LocalDate.of(2000, 1, 1));
        System.out.println(ageMsg+age);
        System.out.println(env.getProperty("cust.age.msg")+" "+age);
        System.out.println("Profile Is "+ util.getProfile());
    }
}
