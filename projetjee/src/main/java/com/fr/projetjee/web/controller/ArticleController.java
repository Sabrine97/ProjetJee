package com.fr.projetjee.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {

  @RequestMapping("/welcome")
  public String welcomepage() {
    return "index";
  }

  @RequestMapping("/articles")
  public String articles() {
    return "articles";
  }
}
