package com.example.syscom.model;

public class VerifStock {
    String article;
    Double nombre_besoin;
    Double nombre_stock;
    Double pu;

    public VerifStock() {
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Double getNombre_besoin() {
        return nombre_besoin;
    }

    public void setNombre_besoin(Double nombre_besoin) {
        this.nombre_besoin = nombre_besoin;
    }

    public Double getNombre_stock() {
        return nombre_stock;
    }

    public void setNombre_stock(Double nombre_stock) {
        this.nombre_stock = nombre_stock;
    }

    public Double getPu() {
        return pu;
    }

    public void setPu(Double pu) {
        this.pu = pu;
    }
}
