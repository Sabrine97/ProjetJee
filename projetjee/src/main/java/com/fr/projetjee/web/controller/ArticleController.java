package com.fr.projetjee.web.controller;
import javax.annotation.PostConstruct;

import com.fr.projetjee.persistence.entities.User;
import com.fr.projetjee.service.impl.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {

  @Autowired
  private UserService userService;

  @PostConstruct
  public void init(){
    User user = new User();
    user.setUsername("user");
    user.setPassword("user");
    userService.save(user);
  }
  @RequestMapping("/welcome")
  public String welcomepage() {

    return "index";
  }

  @RequestMapping("/articles")
  public String articles() {
    return "articles";
  }
}
