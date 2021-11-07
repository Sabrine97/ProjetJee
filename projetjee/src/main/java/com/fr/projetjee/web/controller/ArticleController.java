package com.fr.projetjee.web.controller;

import java.util.List;
import com.fr.projetjee.service.IArticleService;
import com.fr.projetjee.service.model.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArticleController {

  @Autowired
  private IArticleService articleService;
 
  @RequestMapping("/welcome")
  public String welcomepage() {
    return "index";
  }

  @RequestMapping("/articles")
  public ModelAndView showArticles() {
    List<Article> articleList = articleService.findAllArticle();
    ModelAndView modelAndView = new ModelAndView("articles");
    modelAndView.addObject("articleList", articleList);
    modelAndView.addObject("articleRecherche", new Article());
    return modelAndView;
  }

  @RequestMapping("/recherche")
  public ModelAndView showRechercheArticles(@ModelAttribute("articleRecherche") Article articleRecherche) {
    List<Article> articleList = articleService.findAllArticle();
    ModelAndView modelAndView = new ModelAndView("articles");
     if(!articleRecherche.getNom().equals("")){
        articleList = articleService.findArticleByName(articleRecherche.getNom());
      }
      modelAndView.addObject("articleRecherche", articleRecherche);
    modelAndView.addObject("articleList", articleList);
    return modelAndView;
  }

  @RequestMapping(value= "/new")
  public ModelAndView showAddFormArticle() {
    ModelAndView modelAndView = new ModelAndView("article_create");
    modelAndView.addObject("article", new Article());
    return modelAndView;
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createArticle(@ModelAttribute("article") Article article) {
		this.articleService.addArticle(article);
    return "redirect:/articles";

	}

  @RequestMapping("/delete")
  public String deleteArticle(@RequestParam("id") int id) {
    articleService.removeArticle(id);
    return "redirect:/articles";
  }

  @RequestMapping(value="/edit", method = RequestMethod.GET)
  public ModelAndView showModifierArticle(@RequestParam("id") int id) {
    Article article = articleService.findArticleById(id);
    ModelAndView modelAndView = new ModelAndView("article_update");
    modelAndView.addObject("article", article);
    return modelAndView;
  }

  @RequestMapping(value="/update", method = RequestMethod.POST)
  public String modifierArticle(@ModelAttribute("article") Article article) {
    articleService.updateArticle(article.getId(), article);
    return "redirect:/articles";
  }

  @RequestMapping(value="/details", method = RequestMethod.GET)
  public ModelAndView showDetailsArticle(@RequestParam("id") int id) {
    Article article = articleService.findArticleById(id);
    ModelAndView modelAndView = new ModelAndView("article_details");
    modelAndView.addObject("article", article);
    return modelAndView;
  }

}
