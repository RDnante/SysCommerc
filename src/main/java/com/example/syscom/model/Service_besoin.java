package com.example.syscom.model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "service_besoin")
public class Service_besoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_servicebesoin;

    @Column(name = "id_service")
    Integer id_service;

    @Column(name = "id_article")
    Integer id_article;

    @Column(name = "quantite")
    Double quantite;

    @Column(name = "date")
    LocalDate date;

    @Column(name = "status")
    Integer status;

    public Service_besoin(Integer id_servicebesoin, Integer id_service, Integer id_article, Double quantite, LocalDate date,
            Integer status) {
        this.id_servicebesoin = id_servicebesoin;
        this.id_service = id_service;
        this.id_article = id_article;
        this.quantite = quantite;
        this.date = date;
        this.status = status;
    }

    public Service_besoin() {
    }

    public Integer getId_servicebesoin() {
        return id_servicebesoin;
    }

    public void setId_servicebesoin(Integer id_servicebesoin) {
        this.id_servicebesoin = id_servicebesoin;
    }

    public Integer getId_service() {
        return id_service;
    }

    public void setId_service(Integer id_service) {
        this.id_service = id_service;
    }

    public Integer getId_article() {
        return id_article;
    }

    public void setId_article(Integer id_article) {
        this.id_article = id_article;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
