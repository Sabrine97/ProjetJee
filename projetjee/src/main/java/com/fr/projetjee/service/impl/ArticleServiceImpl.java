package com.fr.projetjee.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fr.projetjee.persistence.entities.ArticleEntity;
import com.fr.projetjee.persistence.repository.ArticleRepository;
import com.fr.projetjee.service.IArticleService;
import com.fr.projetjee.service.model.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ArticleServiceImpl implements IArticleService{

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void addArticle(Article article) {
        ArticleEntity articleEntity = convertToEntity(article);
        this.articleRepository.save(articleEntity);        
    }

    @Override
    public void updateArticle(Article article, Article modifiedArticle) {
        final Article art = this.findArticleById(article.getId());
		art.setNom(modifiedArticle.getNom());
		art.setFabDate(modifiedArticle.getFabDate());
		art.setExpDate(modifiedArticle.getExpDate());
        ArticleEntity articleEntity = convertToEntity(article);
		this.articleRepository.save(articleEntity);        
    }

    @Override
    public void removeArticle(int id) {
        this.articleRepository.deleteById(id);        
    }

    @Override
    public List<Article> findArticleByName(String name) {
        List<ArticleEntity> articlesEntities = this.articleRepository.findArticleByNom(name);
        List<Article> articles = new ArrayList<>();
        for(int i = 0; i < articlesEntities.size(); i++) {
            // a remplir
        }     
        return articles;
    }

    @Override
    public Article findArticleById(int id) {
        ArticleEntity optionalArticle = this.articleRepository.findById(id);

        return null;

    }

    @Override
    public List<Article> findAllArticle() {
        List<ArticleEntity> articlesEntities = this.articleRepository.findAll();
            
        return null;
    }

    private Article maptoArticle(ArticleEntity aEntity){ 
            Article article = new Article();
            article.setExpDate(aEntity.getExpDate());
            article.setFabDate(aEntity.getFabDate());
            article.setId(aEntity.getId());
            article.setNom(aEntity.getNom());
            article.setPrix(aEntity.getPrix());
            article.setQuantity(aEntity.getQuantity());
            return article;
    }

    ArticleEntity convertToEntity(Article article) {
        return null;
    }
    
}
