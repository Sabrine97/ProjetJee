package com.fr.projetjee.persistence.repository;

import java.util.List;

import com.fr.projetjee.persistence.entities.ArticleEntity;

//import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository //extends JpaRepository<ArticleEntity, Integer>
{

    public List<ArticleEntity> findArticleByNom(String name);

    public List<ArticleEntity> findArticleByNomLike(String search);
}
