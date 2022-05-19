package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    
    @RequestMapping("test")
    public String test(){

        return "test";
    }

    @RequestMapping("test2")
    public String test2(){
        System.out.println("test2");
        return "test2";
    }
}
