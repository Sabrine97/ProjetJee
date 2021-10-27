package com.fr.projetjee.persistence.repository;

import com.fr.projetjee.persistence.entities.ArticleEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer>{
    
}
