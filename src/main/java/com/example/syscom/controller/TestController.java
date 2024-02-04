package com.example.syscom.controller;

import com.example.syscom.model.Article;
import com.example.syscom.model.Articletest;
import com.example.syscom.model.Categorie;
import com.example.syscom.model.Immobilisations;
import com.example.syscom.repository.ArticleRepository;
import com.example.syscom.repository.CategorieRepository;
import com.example.syscom.service.LineaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    CategorieRepository categorieRepository;
    @Autowired
    LineaireService lineaireService;
    @GetMapping("/test")
    public String nom(Model model, HttpServletRequest request) {

        Articletest articletest = new Articletest();
        articletest.test();

        Categorie c = new Categorie();
        c.setNom("Ustensile");

        categorieRepository.save(c);

        return "test";
    }

    @GetMapping("/lin")
    public String lin(Model model) {
        List<Immobilisations> ale = lineaireService.calcule_lineaire(1);
        model.addAttribute("list_im",ale);

        return "linaire";
    }
}
