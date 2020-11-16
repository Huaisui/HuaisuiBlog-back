package com.huaisui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "huaisui.html";
    }

    @GetMapping("/upload")
    public String upload(){
        return "blog_upload.html";
    }

    @GetMapping("/article")
    public String article(){
        return "article_page.html";
    }

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

    @GetMapping("/errorpage")
    public String error(){
        return "error.html";
    }
}
