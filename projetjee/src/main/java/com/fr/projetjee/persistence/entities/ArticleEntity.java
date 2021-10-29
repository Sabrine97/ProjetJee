package com.fr.projetjee.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fr.projetjee.persistence.repository.ArticleRepository;
import com.fr.projetjee.service.model.Article;

//test: ceci est une nouvelle branche!

@Entity
public class ArticleEntity implements Serializable{
    @Id
    @GeneratedValue
    private int id;

    private String nom;

    private Date expDate;

    private Date fabDate; 

    private int quantity;

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
