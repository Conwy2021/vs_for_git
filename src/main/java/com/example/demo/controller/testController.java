package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @RequestMapping("test3")
    public void test3(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String url =request.getParameter("url");

        System.out.println(url);
        System.out.println("no bug jar");
       
        
    }
}
