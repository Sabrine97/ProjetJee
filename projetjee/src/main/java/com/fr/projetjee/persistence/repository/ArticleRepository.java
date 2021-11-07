package com.fr.projetjee.persistence.repository;

import com.fr.projetjee.persistence.entities.ArticleEntity;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 * Couche persistence, utilisation Hibernate
 */
@Repository
@Transactional
public class ArticleRepository {

  @Autowired
  private SessionFactory sessionFactory;
/**
 * Permet de sauvegarder un articleEntity
 * @param article
 */
  @Transactional
  public void save(ArticleEntity article) {
    Session session = this.sessionFactory.getCurrentSession();
    session.save(article);
  }
/**
 * Permet de modifier un articleEntity
 * @param article
 */
  @Transactional
  public void update(ArticleEntity article) {
    Session session = this.sessionFactory.getCurrentSession();
    session.saveOrUpdate(article);
  }
/**
 * Permet de supprimer un articleEntity par id
 * @param id
 */
  @Transactional
  public void deleteById(Integer id) {
    Session session = this.sessionFactory.getCurrentSession();
    ArticleEntity article = session.get(ArticleEntity.class, id);
    session.delete(article);
  }
/**
 * Permet de récuperer une liste d'articleEntity par nom
 * @param nom
 * @return Liste d'article
 */
  public List<ArticleEntity> findArticleByNom(String nom) {
    Session session = this.sessionFactory.getCurrentSession();
    List<ArticleEntity> articles = session
      .createQuery(
        "From ArticleEntity where nom like :nom order by id ASC",
        ArticleEntity.class
      )
      .setParameter("nom", "%"+nom+"%")
      .getResultList();

    return articles;
  }
/**
 * Permet de trouver un articleEntity par id
 * @param id
 * @return
 */
  public ArticleEntity findById(Integer id) {
    Session session = this.sessionFactory.getCurrentSession();
    ArticleEntity article = session.get(ArticleEntity.class, id);
    return article;
  }
/**
 * permmet de recuperer tous les articlesEntity
 * @return
 */
  public List<ArticleEntity> findAll() {
    Session session = this.sessionFactory.getCurrentSession();
    List<ArticleEntity> articles = session
      .createQuery("From ArticleEntity order by id ASC")
      .getResultList();
    return articles;
  }
}
