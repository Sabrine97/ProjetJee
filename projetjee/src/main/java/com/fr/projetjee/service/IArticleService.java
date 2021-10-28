package com.fr.projetjee.service;

import java.util.List;

import com.fr.projetjee.service.model.Article;

public interface IArticleService {
    
    public void addArticle(Article article);

    public void updateArticle(Article article, Article modifiedArticle);

    public void removeArticle(int id);

    public Article findArticleById(int id);
    
    public List<Article> findAllArticle();

    public List<Article> findArticleByNom(String name);

    public List<Article> findArticleByNomLike(String search);

    public List<Article> findArticleByPrixBetween(double prixMin, double prixMax);

    public List<Article> findArticleByQuantityLow(int quantity);

}
