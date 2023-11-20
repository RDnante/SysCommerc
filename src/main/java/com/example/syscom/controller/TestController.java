package com.example.syscom.controller;

import com.example.syscom.model.Article;
import com.example.syscom.model.Categorie;
import com.example.syscom.repository.ArticleRepository;
import com.example.syscom.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestController {
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    CategorieRepository categorieRepository;
    @GetMapping("/test")
    public String nom(Model model, HttpServletRequest request) {

        Categorie c = new Categorie();
        c.setNom("Ustensile");

        categorieRepository.save(c);

        return "test";
    }
}
