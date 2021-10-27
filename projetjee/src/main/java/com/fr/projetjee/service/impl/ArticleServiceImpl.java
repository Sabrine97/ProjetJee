package com.fr.projetjee.service.impl;

import java.text.ParseException;
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
    private Article article;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void addArticle(Article article) {
        ArticleEntity articleEntity = convertToEntity(article);
        this.articleRepository.save(articleEntity);        
    }

    @Override
    public void updateArticle(Article article) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeArticle(int id) {
        this.articleRepository.removeArticle(id);        
    }

    @Override
    public List<Article> findArticleByName(String name) {
        // TODO Auto-generated method stub
        return null;
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
        // TODO Auto-generated method stub
        return null;
    }

    ArticleEntity convertToEntity(Article article) {
        return (ArticleEntity) article.map();
    }
    
}
