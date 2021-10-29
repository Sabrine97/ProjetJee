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
        ArticleEntity articleEntity = convertToEntity(art);
		this.articleRepository.save(articleEntity);        
    }

    @Override
    public void removeArticle(int id) {
        this.articleRepository.deleteById(id);        
    }

    @Override
    public List<Article> findArticleByNom(String name) {
        List<ArticleEntity> articlesEntities = this.articleRepository.findArticleByNom(name);
        List<Article> articles = new ArrayList<>();
        for(int i = 0; i < articlesEntities.size(); i++) {
            articles.add(articlesEntities.get(i).convertToDto(articleRepository));
        }     
        return articles;
    }

    @Override
    public Article findArticleById(int id) {
        Optional<ArticleEntity> optionalArticle = this.articleRepository.findById(id);
        if (optionalArticle.isPresent()) {
            return optionalArticle.get().convertToDto(articleRepository);
        }
		else {
            return null;
        }
    }

    @Override
    public List<Article> findAllArticle() {
        List<ArticleEntity> articlesEntities = this.articleRepository.findAll();
        List<Article> articles = new ArrayList<>();
        for(int i = 0; i < articlesEntities.size(); i++) {
            articles.add(articlesEntities.get(i).convertToDto(articleRepository));
        }     
        return articles;
    }

    public List<Article> findArticleByNomLike(String search) {
        List<ArticleEntity> articlesEntities = this.articleRepository.findArticleByNomLike("%" + search + "%");
        List<Article> articles = new ArrayList<>();
        for(int i = 0; i < articlesEntities.size(); i++) {
            articles.add(articlesEntities.get(i).convertToDto(articleRepository));
        }     
        return articles;
    }

    public List<Article> findArticleByPrixBetween(double prixMin, double prixMax) {
        List<ArticleEntity> articlesEntities = this.articleRepository.findAll();
        List<Article> articles = new ArrayList<>();
        for(int i = 0; i < articlesEntities.size(); i++) {
            if (articlesEntities.get(i).getPrix() <= prixMax && articlesEntities.get(i).getPrix() >= prixMin) {
                articles.add(articlesEntities.get(i).convertToDto(articleRepository));
            }
        }     
        return articles;
    }

    public List<Article> findArticleByQuantityLow(int quantity) {
        List<ArticleEntity> articlesEntities = this.articleRepository.findAll();
        List<Article> articles = new ArrayList<>();
        for(int i = 0; i < articlesEntities.size(); i++) {
            if (articlesEntities.get(i).getQuantity() <= quantity) {
                articles.add(articlesEntities.get(i).convertToDto(articleRepository));
            }
        }     
        return articles;
    }

    ArticleEntity convertToEntity(Article article) {
        return (ArticleEntity) article.map();
    }
    
}
