package com.fr.projetjee.service;

import com.fr.projetjee.service.model.Article;
import java.util.List;

public interface IArticleService {
  /**
   *Permet d'ajouter un article dans la couche metier
   * @param article
   */
  public void addArticle(Article article);

  /**
   *Permet de modifier un article dans la couche metier
   * @param id
   * @param modifiedArticle
   */
  public void updateArticle(int id, Article modifiedArticle);

  /**
   *Permet de supprimer un article dans la couche metier
   * @param id
   */
  public void removeArticle(int id);

  /**
   *Permet de trouver un article par nom dans la couche metier
   * @param name
   * @return
   */
  public List<Article> findArticleByName(String name);

  /**
   *Permet de trouver un article par id dans la couche metier
   * @param id
   * @return
   */
  public Article findArticleById(int id);

  /**
   *Permet de trouver tous les articles dans la couche metier
   * @return
   */
  public List<Article> findAllArticle();
}
