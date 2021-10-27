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
        this.articleRepository.removeArticle(id);        
    }

    @Override
    public List<Article> findArticleByName(String name) {
        List<ArticleEntity> articlesEntities = this.articleRepository.findArticleByName(name);
        List<Article> articles = new ArrayList<>();
        for(int i = 0; i < articlesEntities.size(); i++) {
            articles.add(articlesEntities.get(i).convertToDto(articleRepository));
        }     
        return articles;
    }

    @Override
    public Article findArticleById(int id) {
        Optional<ArticleEntity> optionalArticle = this.articleRepository.findArticleById(id);
        if (optionalArticle.isPresent()) {
            return optionalArticle.get().convertToDto(articleRepository);
        }
		else {
            return null;
        }
    }

    @Override
    public List<Article> findAllArticle() {
        List<ArticleEntity> articlesEntities = this.articleRepository.findAllArticles();
        List<Article> articles = new ArrayList<>();
        for(int i = 0; i < articlesEntities.size(); i++) {
            articles.add(articlesEntities.get(i).convertToDto(articleRepository));
        }     
        return articles;
    }

    ArticleEntity convertToEntity(Article article) {
        return (ArticleEntity) article.map();
    }
    
}
