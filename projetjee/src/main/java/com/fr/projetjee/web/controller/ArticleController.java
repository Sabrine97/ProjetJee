package com.fr.projetjee.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {

    @RequestMapping("/login")
    public String hello() {
        return "Hello";
    }
    
    @RequestMapping("/home")
    public String home(){
        return "/articles";
    }
}
