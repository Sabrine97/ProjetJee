package com.fr.projetjee.web.controller;

import com.fr.projetjee.persistence.entities.User;
import com.fr.projetjee.service.impl.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {
    
    
    @RequestMapping("/home")
    public String home(){
        return "/articles";
    }

    @RequestMapping("/login")
    public ResponseEntity<User> getUser(){

       User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return  new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
