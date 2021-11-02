package com.fr.projetjee.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.fr.projetjee.service.IArticleService;
import com.fr.projetjee.service.model.Article;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
 
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.cfg.Configuration;


@Service
@Transactional
public class ArticleServiceImpl implements IArticleService{

    Configuration config = new Configuration();
    private static final SessionFactory sf = new Configuration().configure().buildSessionFactory();
 
    public List<Article> getAllArticles() {
        
        Session session = sf.openSession();
        Transaction transaction = null;
        List<Article> users = null;
        try {
            transaction = session.beginTransaction();
            users = session.createQuery("from Article", Article.class).list();
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Exception occurred" + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return users;
    }

    public Article getArticle(int id) {

        Session session = sf.openSession();
        Transaction transaction = null;
        List<Article> articles = null;
        try {
            transaction = session.beginTransaction();
            Query<Article> query = session.createQuery("from Article where id =:id", Article.class);
            query.setParameter("id", id);
            query.executeUpdate();
            articles = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Exception occurred" + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return articles.get(0);
    }

    public boolean deleteArticle(int id) {

        Session session = sf.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query<Article> query = session.createQuery("delete from Article where id =:id", Article.class);
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Exception occurred" + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        } finally {
            session.close();
        }
    }

    public boolean addArticle(Article article) {
        Session session = sf.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(article);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Exception occurred" + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        } finally {
            session.close();
        }
    }

    public boolean updateArticle(Article article, Article modifiedArticle) {
        Session session = sf.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query<Article> query =session.createQuery("update Article set nom=:nom, expDate = :expDate, fabDate = :fabDate, prix = :prix, quantity = :quantity where id=:i", Article.class);  
            query.setParameter("nom", modifiedArticle.getNom()); 
            query.setParameter("expDate", modifiedArticle.getExpDate());
            query.setParameter("fabDate", modifiedArticle.getFabDate());
            query.setParameter("prix", modifiedArticle.getPrix());
            query.setParameter("quantity", modifiedArticle.getQuantity());
            query.setParameter("i",article.getId());
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Exception occurred" + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        } finally {
            session.close();
        }
    }

    /*
    @Override
    public void addArticle(Article article) {
        ArticleEntity articleEntity = convertToEntity(article);
        this.articleRepository.save(articleEntity);        
    }

    @Override
    public void updateArticle(Article article, Article modifiedArticle) {
        final Article art = this.findArticleById(article.getId());
		art.setNom(modifiedArticle.getNom());
		art.setFabDate(modifiedArticle.getFabDate());
		art.setExpDate(modifiedArticle.getExpDate());
        ArticleEntity articleEntity = convertToEntity(art);
		this.articleRepository.save(articleEntity);        
    }

    @Override
    public void removeArticle(int id) {
        this.articleRepository.deleteById(id);        
    }

    @Override
    public List<Article> findArticleByNom(String name) {
        List<ArticleEntity> articlesEntities = this.articleRepository.findArticleByNom(name);
        List<Article> articles = new ArrayList<>();
        for(int i = 0; i < articlesEntities.size(); i++) {
            articles.add(articlesEntities.get(i).convertToDto(articleRepository));
        }     
        return articles;
    }

    @Override
    public Article findArticleById(int id) {
        Optional<ArticleEntity> optionalArticle = this.articleRepository.findById(id);
        if (optionalArticle.isPresent()) {
            return optionalArticle.get().convertToDto(articleRepository);
        }
		else {
            return null;
        }
    }

    @Override
    public List<Article> findAllArticle() {
        List<ArticleEntity> articlesEntities = this.articleRepository.findAll();
        List<Article> articles = new ArrayList<>();
        for(int i = 0; i < articlesEntities.size(); i++) {
            articles.add(articlesEntities.get(i).convertToDto(articleRepository));
        }     
        return articles;
    }

    public List<Article> findArticleByNomLike(String search) {
        List<ArticleEntity> articlesEntities = this.articleRepository.findArticleByNomLike("%" + search + "%");
        List<Article> articles = new ArrayList<>();
        for(int i = 0; i < articlesEntities.size(); i++) {
            articles.add(articlesEntities.get(i).convertToDto(articleRepository));
        }     
        return articles;
    }

    public List<Article> findArticleByPrixBetween(double prixMin, double prixMax) {
        List<ArticleEntity> articlesEntities = this.articleRepository.findAll();
        List<Article> articles = new ArrayList<>();
        for(int i = 0; i < articlesEntities.size(); i++) {
            if (articlesEntities.get(i).getPrix() <= prixMax && articlesEntities.get(i).getPrix() >= prixMin) {
                articles.add(articlesEntities.get(i).convertToDto(articleRepository));
            }
        }     
        return articles;
    }

    public List<Article> findArticleByQuantityLow(int quantity) {
        List<ArticleEntity> articlesEntities = this.articleRepository.findAll();
        List<Article> articles = new ArrayList<>();
        for(int i = 0; i < articlesEntities.size(); i++) {
            if (articlesEntities.get(i).getQuantity() <= quantity) {
                articles.add(articlesEntities.get(i).convertToDto(articleRepository));
            }
        }     
        return articles;
    }

    ArticleEntity convertToEntity(Article article) {
        return (ArticleEntity) article.map();
    }*/
    
}
