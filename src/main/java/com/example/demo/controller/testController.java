package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

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

        response.sendRedirect(url);
        
    }

    @RequestMapping("test4")
    public String test4(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String url = request.getParameter("url");
        System.out.println(url);
        URL u = new URL(url);
        URLConnection urlConnection = u.openConnection();
        urlConnection.setAllowUserInteraction(true);
        /*未对输入参数进行验证，导致访问地址可控，出现SSRF漏洞*/
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        // 打印从服务器读取的报文
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }


        return "SSRFtest";
    }
}
