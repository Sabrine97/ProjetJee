package com.fr.projetjee.service.model;

import java.util.Date;

public class Article {
    private int id_article;

    private String name_article;

    private Date date_exp;

    private Date date_fab; 

    public int getId_article() {
        return this.id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public String getName_article() {
        return this.name_article;
    }

    public void setName_article(String name_article) {
        this.name_article = name_article;
    }

    public Date getDate_exp() {
        return this.date_exp;
    }

    public void setDate_exp(Date date_exp) {
        this.date_exp = date_exp;
    }

    public Date getDate_fab() {
        return this.date_fab;
    }

    public void setDate_fab(Date date_fab) {
        this.date_fab = date_fab;
    }

}
