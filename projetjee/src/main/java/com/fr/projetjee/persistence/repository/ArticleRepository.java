package com.fr.projetjee.persistence.repository;

import java.util.List;

import com.fr.projetjee.persistence.entities.ArticleEntity;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ArticleRepository{
    @Autowired
    private SessionFactory sessionFactory;
    
    public void save(ArticleEntity article){      
    }
    public void update(ArticleEntity article){      
    }

    public void deleteById(Integer id){      
    }

    public List<ArticleEntity> findArticleByNom(String name){
        return null;
    }

    public ArticleEntity findById( Integer id){
        return null;
    }

    public List<ArticleEntity> findAll(){
        return null;
    }
 }

