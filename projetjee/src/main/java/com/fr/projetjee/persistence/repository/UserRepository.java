package com.fr.projetjee.persistence.repository;

import com.fr.projetjee.persistence.entities.User;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * Couche persistence, utilisation Hibernate
 */
@Repository
@Transactional
public class UserRepository {
  @Autowired
  private SessionFactory sessionFactory;
/**
 * Permet de récuper un utilisateyr par son username
 * @param username
 * @return
 */
  @Transactional
  public User getUserByUserName(String username) {
    Session session = this.sessionFactory.getCurrentSession();
    User user = session.createQuery("From User where username = :username", User.class).setParameter("username", username).uniqueResult();
    return user;
  }
  /**
   * Permet de sauvegarder un utilisateur
   * @param user
   */
  @Transactional
  public void save(User user) {
    Session session = this.sessionFactory.getCurrentSession();
    session.save(user);
  }
}
