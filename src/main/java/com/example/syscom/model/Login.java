package com.example.syscom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idlogin;
    @Column(name = "idservice")
    Integer idservice;
    @Column(name = "idposte")
    Integer idposte;
    @Column(name = "password")
    String password;
    public Login(Integer idlogin, Integer idservice, Integer idposte, String password) {
        this.idlogin = idlogin;
        this.idservice = idservice;
        this.idposte = idposte;
        this.password = password;
    }
    public Login() {
    }
    public Integer getIdlogin() {
        return idlogin;
    }
    public void setIdlogin(Integer idlogin) {
        this.idlogin = idlogin;
    }
    public Integer getIdservice() {
        return idservice;
    }
    public void setIdservice(Integer idservice) {
        this.idservice = idservice;
    }
    public Integer getIdposte() {
        return idposte;
    }
    public void setIdposte(Integer idposte) {
        this.idposte = idposte;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
    

   


    
}
