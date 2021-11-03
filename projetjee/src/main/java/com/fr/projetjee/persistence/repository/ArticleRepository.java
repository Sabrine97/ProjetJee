package com.fr.projetjee.persistence.repository;

import com.fr.projetjee.persistence.entities.ArticleEntity;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ArticleRepository {

  @Autowired
  private SessionFactory sessionFactory;

  @Transactional
  public void save(ArticleEntity article) {
    Session session = this.sessionFactory.getCurrentSession();
    session.save(article);
  }

  @Transactional
  public void update(ArticleEntity article) {
    Session session = this.sessionFactory.getCurrentSession();
    session.saveOrUpdate(article);
  }

  @Transactional
  public void deleteById(Integer id) {
    Session session = this.sessionFactory.getCurrentSession();
    ArticleEntity article = session.get(ArticleEntity.class, id);
    session.delete(article);
  }

  public List<ArticleEntity> findArticleByNom(String name) {
    return null;
  }

  public ArticleEntity findById(Integer id) {
    return null;
  }

  public List<ArticleEntity> findAll() {
    Session session = this.sessionFactory.getCurrentSession();
    List<ArticleEntity> articles = session
      .createQuery("From ArticleEntity")
      .getResultList();
    return articles;
  }
}
