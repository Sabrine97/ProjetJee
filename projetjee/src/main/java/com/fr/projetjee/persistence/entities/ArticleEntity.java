package com.fr.projetjee.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fr.projetjee.persistence.repository.ArticleRepository;
import com.fr.projetjee.service.model.Article;


@Entity
@Table(name= "article")
public class ArticleEntity implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="nom")
    private String nom;
    @Column(name="exp_date")
    private Date expDate;
    @Column(name="fab_date")
    private Date fabDate; 
    @Column(name="quantity")
    private Integer quantity;
    @Column(name="prix")
    private double prix;

    public double getPrix() {
        return this.prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getExpDate() {
        return this.expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Date getFabDate() {
        return this.fabDate;
    }

    public void setFabDate(Date fabDate) {
        this.fabDate = fabDate;
    }

    public Article convertToDto(ArticleRepository articleRepository) {
        return (Article) articleRepository;
    }


}
