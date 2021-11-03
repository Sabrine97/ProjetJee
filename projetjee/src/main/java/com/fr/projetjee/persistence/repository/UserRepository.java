package com.fr.projetjee.persistence.repository;

import com.fr.projetjee.persistence.entities.User;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserRepository {
  @Autowired
  private SessionFactory sessionFactory;

  @Transactional
  public User getUserByUserName(String username) {
    Session session = this.sessionFactory.getCurrentSession();
    User user = session.createQuery("From User where username = :username", User.class).setParameter("username", username).uniqueResult();
    return user;
  }
  @Transactional
  public void save(User user) {
    Session session = this.sessionFactory.getCurrentSession();
    session.save(user);
  }
}
