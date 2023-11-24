package com.example.syscom.controller;

import com.example.syscom.model.Article;
import com.example.syscom.model.BonDeCommande;
import com.example.syscom.model.Fournisseur;
import com.example.syscom.model.Proforma;
import com.example.syscom.model.Service_besoin;
import com.example.syscom.repository.ArticleRepository;
import com.example.syscom.repository.FournisseurRepository;
import com.example.syscom.repository.Service_besoinRepository;
import com.example.syscom.service.BonDeCommandeService;
import com.example.syscom.service.ProformaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Abraca {

    @Autowired
    FournisseurRepository fournisseurRepository;
    @Autowired
    Service_besoinRepository serviceBesoinRepository;
    @Autowired
    ProformaService proformaService;
    @Autowired
    BonDeCommandeService bonDeCommandeService;
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/login")
    public String login(Model model) {

        return "index";
    }

    @PostMapping("/dash")
    public String dash(Model model) {

        return "acceuil";
    }

    @GetMapping("/dash")
    public String dashi(Model model) {

        return "acceuil";
    }

    @GetMapping("/besoin")
    public String besoin(Model model) {
        List<Article> all = articleRepository.findAll();
        model.addAttribute("article", all);
        return "besoin";
    }

    @PostMapping("/besoin/inserer")
    public String inserer_besoin(Model model, @RequestParam("article") String article, @RequestParam("quantite") Double quantite){

        Service_besoin s = new Service_besoin();
        s.setId_service(1);
        s.setId_article(Integer.valueOf(article));
        s.setQuantite(quantite);
        s.setDate(LocalDate.now());

        serviceBesoinRepository.save(s);

        return "acceuil";
    }

    @GetMapping("/listproforma")
    public String list(Model model) {
        List<Proforma> list = proformaService.getProforma(1);
        System.out.println("size list"+list.size());
        model.addAttribute("listproforma",list);

        return "proformalist";
    }

    @GetMapping("/proforma/{id}")
    public String proforma(Model model, @PathVariable Integer id) {
        Proforma p = proformaService.getProformabyent(1,id);
        model.addAttribute("proforma",p);

        return "proforma";
    }

    @GetMapping("/bclist")
    public String bclist(Model model) {
        List<BonDeCommande> listbd = bonDeCommandeService.listbon(1);

        model.addAttribute("listbon",listbd);

        return "boncommandelist";
    }

    @GetMapping("/boncommande")
    public String bc(Model model) {
        List<Fournisseur> all = fournisseurRepository.findAll();
        model.addAttribute("fournisseur", all);
        return "boncommandelist";
    }

    @GetMapping("/bondctest/{id}")
    public String getBonDeCommande(Model model,@PathVariable Integer id){
        try {
            BonDeCommande b = bonDeCommandeService.getBonDeCommandeByFournisseur(1, id);
            model.addAttribute("bdc", b);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "boncommande";
    }
}
