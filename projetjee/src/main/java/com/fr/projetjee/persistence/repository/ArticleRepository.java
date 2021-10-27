package com.fr.projetjee.persistence.repository;

import java.util.List;
import java.util.Optional;

import com.fr.projetjee.persistence.entities.ArticleEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer>{

    public Optional<ArticleEntity> findArticleById(int id);

    public List<ArticleEntity> findArticleByName(String name);

    public List<ArticleEntity> findAllArticles();

    public ArticleEntity addArticle(ArticleEntity article);

    public void removeArticle(int id);

    public ArticleEntity updateArticle(ArticleEntity article, ArticleEntity modifiedArticle);
    
}
