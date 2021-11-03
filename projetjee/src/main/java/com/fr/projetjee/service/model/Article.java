package com.fr.projetjee.service.model;

import java.util.Date;

import com.fr.projetjee.persistence.repository.ArticleRepository;

public class Article {

    private int id;
    private String nom;

    private Date expDate;

    private Date fabDate; 

    private double prix;

    private int quantity;

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

}
