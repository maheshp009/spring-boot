package com.ani.enterprise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class WelcomeController {

    @GetMapping(value = "")
    public String hello() {
        return "Welcome To Mobile ERP";
    }

    @GetMapping(value = "/demo") // /demo is called path
    public String custom() {
        return "This for demo only";
    }
}
