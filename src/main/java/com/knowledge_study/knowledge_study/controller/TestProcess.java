package com.knowledge_study.knowledge_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class hello {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
