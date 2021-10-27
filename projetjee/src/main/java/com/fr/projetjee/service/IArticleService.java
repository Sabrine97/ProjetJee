package com.fr.projetjee.service;

import java.util.List;

import com.fr.projetjee.service.model.Article;

public interface IArticleService {
    
    public void addArticle(Article article);

    public void updateArticle(Article article);

    public void removeArticle(int id);

    public List<Article> findArticleByName(String name);

    public Article findArticleById(int id);
    
    public List<Article> findAllArticle();

}
