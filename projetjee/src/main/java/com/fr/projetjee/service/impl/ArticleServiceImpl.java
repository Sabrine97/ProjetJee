package com.fr.projetjee.service.impl;

import com.fr.projetjee.persistence.entities.ArticleEntity;
import com.fr.projetjee.persistence.repository.ArticleRepository;
import com.fr.projetjee.service.IArticleService;
import com.fr.projetjee.service.model.Article;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements IArticleService {

  @Autowired
  private ArticleRepository articleRepository;

  @Override
  public void addArticle(Article article) {
    ArticleEntity articleEntity = convertToEntity(article);
    this.articleRepository.save(articleEntity);
  }

  @Override
  public void updateArticle(int id, Article modifiedArticle) {
    final Article art = this.findArticleById(id);
    art.setNom(modifiedArticle.getNom());
    art.setDescription(modifiedArticle.getDescription());
    art.setPrix(modifiedArticle.getPrix());
    art.setQuantite(modifiedArticle.getQuantite());
    ArticleEntity articleEntity = convertToEntity(modifiedArticle);
    this.articleRepository.update(articleEntity);
  }

  @Override
  public void removeArticle(int id) {
    this.articleRepository.deleteById(id);
  }

  @Override
  public List<Article> findArticleByName(String name) {
    List<ArticleEntity> articlesEntities =
      this.articleRepository.findArticleByNom(name);
    List<Article> articles = new ArrayList<>(); //je déclare une liste d'article vide
    for(ArticleEntity aEntity : articlesEntities){
        Article article = this.maptoArticle(aEntity);// je transforme  ArticleEntity en Article
        articles.add(article); // j'ajoute dans ma liste d'article
    }
    return articles;
  }
/**
 * 
 * 
 */

  @Override
  public Article findArticleById(int id) {
    ArticleEntity articleEntity = this.articleRepository.findById(id); // je recherche un articleEntity par son id
    Article article = this.maptoArticle(articleEntity);//je transforme ArticleEntity en article
    return article;// je retourne article
  }
/**
 * 
 * 
 */
  @Override
  public List<Article> findAllArticle() {
    List<ArticleEntity> articlesEntities = this.articleRepository.findAll(); //je récupere la liste des articleEntity qui sont dans la table articles
    List<Article> articles = new ArrayList<>(); //je déclare une liste d'article vide

    for (ArticleEntity aEntity : articlesEntities) { // pour chaque articleEntity
      Article article = this.maptoArticle(aEntity);// je transforme  ArticleEntity en Article
      articles.add(article); // j'ajoute dans ma liste d'article
    }

    return articles;// je retourne ma liste d'article
  }
/**
 * 
 * @param aEntity
 * @return
 */
  private Article maptoArticle(ArticleEntity aEntity) {
    Article article = new Article();
    article.setQuantite(aEntity.getQuantite());
    article.setId(aEntity.getId());
    article.setNom(aEntity.getNom());
    article.setPrix(aEntity.getPrix());
    article.setDescription(aEntity.getDescription());
    return article;
  }

  ArticleEntity convertToEntity(Article article) {
    ArticleEntity articleEntity = new ArticleEntity();
    articleEntity.setQuantite(article.getQuantite());
    articleEntity.setId(article.getId());
    articleEntity.setNom(article.getNom());
    articleEntity.setPrix(article.getPrix());
    articleEntity.setDescription(article.getDescription());
    return articleEntity;
  }
}
