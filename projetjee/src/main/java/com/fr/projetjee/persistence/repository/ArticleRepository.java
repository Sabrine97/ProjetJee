package com.fr.projetjee.persistence.repository;

import java.util.List;
import java.util.Optional;

import com.fr.projetjee.persistence.entities.ArticleEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer>{

    //public Optional<ArticleEntity> findArticleById(int id);

    public List<ArticleEntity> findArticleByNom(String name);

    public List<ArticleEntity> findArticleByNomLike(String search);

    //public List<ArticleEntity> findAll();

    //public ArticleEntity save(ArticleEntity article);

    //public void deleteById(int id);
    // save fais l'update  
    //public ArticleEntity updateArticle(ArticleEntity article, ArticleEntity modifiedArticle);
    
}
