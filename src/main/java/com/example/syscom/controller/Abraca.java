package com.example.syscom.controller;

import com.example.syscom.model.*;
import com.example.syscom.repository.ArticleRepository;
import com.example.syscom.repository.FournisseurRepository;
import com.example.syscom.repository.LoginRepository;
import com.example.syscom.repository.ServiceRepository;
import com.example.syscom.repository.Service_besoinRepository;
import com.example.syscom.service.BonDeCommandeService;
import com.example.syscom.service.ProformaService;
import com.example.syscom.service.ServiceService;
import com.example.syscom.service.Service_besoinService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Autowired
    Service_besoinService serviceBesoinService;
    @Autowired
    ServiceService serviceService;
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    LoginRepository loginRepository;

    @GetMapping("/login")
    public String login(Model model) {

        return "index";
    }

    @GetMapping("/deconnexion")
    public String deconnexion(Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();

        return "index";
    }

    @PostMapping("/dash")
    public String dash(Model model, HttpServletRequest request,@RequestParam("mdp") String mdp) {

        // ServiceC s = serviceRepository.loginServie(nom,mdp);
        Login l = loginRepository.authentification(mdp);
        System.out.println(l);
        if (l != null) {
            // System.out.println("sb,b");
            Service s = serviceRepository.findById(l.getIdservice()).get();
            model.addAttribute("service", s);
            HttpSession session = request.getSession();
            session.setAttribute("idservice",l.getIdservice());
            session.setAttribute("service", s);
            System.out.println(l.getIdposte());
            if (l.getIdposte()==3&&l.getIdservice()==3) {
                List<Article> all = articleRepository.findAll();
                model.addAttribute("article", all);
                return "achat";
            }
            if (l.getIdposte()==4&&l.getIdservice()==3) {
                List<Article> all = articleRepository.findAll();
                model.addAttribute("article", all);
                return "vente";
            }
            if (l.getIdposte()==2&&l.getIdservice()==3) {
                List<Article> all = articleRepository.findAll();
                model.addAttribute("article", all);
                return "magasin";
            }
            if (l.getIdposte()==1) {
                List<Article> all = articleRepository.findAll();
                model.addAttribute("article", all);
                return "employee";
            }else{
                return "acceuil";
            }
        }
        else {
            return "redirect:/login";
        }
    }

    // @GetMapping("/dash")
    // public String dashi(Model model) {

    //     return "acceuil";
    // }

    @GetMapping("/besoinE")
    public String besoinE(Model model, HttpServletRequest request) {
        List<Article> all = articleRepository.findAll();
        model.addAttribute("article", all);
        HttpSession session = request.getSession();
        Service s = (Service)session.getAttribute("service");
        model.addAttribute("service", s);
        return "employee";
    }

    @GetMapping("/besoin")
    public String besoin(Model model, HttpServletRequest request) {
        List<Article> all = articleRepository.findAll();
        model.addAttribute("article", all);
        HttpSession session = request.getSession();
        Service s = (Service)session.getAttribute("service");
        model.addAttribute("service", s);
        return "besoin";
    }

    @PostMapping("/besoin/inserer")
    public String inserer_besoin(Model model, HttpServletRequest request, @RequestParam("article") String article, @RequestParam("quantite") Double quantite){

        Service_besoin s = new Service_besoin();
        s.setId_service(1);
        s.setId_article(Integer.valueOf(article));
        s.setQuantite(quantite);
        s.setDate(LocalDate.now());
        s.setStatus(0);
        HttpSession session = request.getSession();
        Service ss = (Service)session.getAttribute("service");
        model.addAttribute("service", ss);
        serviceBesoinRepository.save(s);

        return "acceuil";
    }

    @GetMapping("/listproforma")
    public String list(Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        String si = session.getAttribute("idservice").toString();
        Integer idservice = Integer.valueOf(si);
        List<Proforma> list = proformaService.getProforma(idservice);
        System.out.println("size list"+list.size());
        model.addAttribute("listproforma",list);
        Service s = (Service)session.getAttribute("service");
        model.addAttribute("service", s);

        return "proformalist";
    }

    @GetMapping("/proforma/{id}")
    public String proforma(Model model, HttpServletRequest request,@PathVariable Integer id) {
        HttpSession session = request.getSession();
        String si = session.getAttribute("idservice").toString();
        Integer idservice = Integer.valueOf(si);
        Proforma p = proformaService.getProformabyent(idservice,id);
        model.addAttribute("proforma",p);
        Service s = (Service)session.getAttribute("service");
        model.addAttribute("service", s);

        return "proforma";
    }

    @GetMapping("/bclist")
    public String bclist(Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        String si = session.getAttribute("idservice").toString();
        Integer idservice = Integer.valueOf(si);
        List<BonDeCommande> listbd = bonDeCommandeService.listbon(idservice);
        Service s = (Service)session.getAttribute("service");
        model.addAttribute("service", s);
        model.addAttribute("listbon",listbd);

        return "boncommandelist";
    }

    @GetMapping("/boncommande")
    public String bc(Model model,HttpServletRequest request) {
         try {
             HttpSession session = request.getSession();
             Integer idservice = Integer.valueOf(session.getAttribute("idservice").toString());
             List<Fournisseur> all = fournisseurRepository.findAll();
             List<Fournisseur> allOk = new ArrayList<>();
             for (int i = 0; i < all.size(); i++) {
                 System.out.println("hgdjgzjdg");
                 if(bonDeCommandeService.getBonDeCommandeByFournisseur(idservice,all.get(i).getId_fournisseur()).getCommandes().size()!=0){
                    allOk.add(all.get(i));
                 }
             }
            Service s = (Service)session.getAttribute("service");
            model.addAttribute("service", s);
             model.addAttribute("fournisseur", allOk);
         } catch (Exception e) {
             System.out.println(e);
         }
        return "boncommandelist";
    }

    @GetMapping("/bondctest/{id}")
    public String getBonDeCommande(Model model,@PathVariable Integer id,HttpServletRequest request){
        HttpSession session = request.getSession();
        String si = session.getAttribute("idservice").toString();
        Integer idservice = Integer.valueOf(si);
        Service s = (Service)session.getAttribute("service");
        model.addAttribute("service", s);
        try {
            BonDeCommande b = bonDeCommandeService.getBonDeCommandeByFournisseur(idservice, id);
            model.addAttribute("bdc", b);
            System.out.println("1212");
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        return "boncommande";
    }

    @GetMapping("/confirmation/{id}")
    public String confirmation(Model model,@PathVariable Integer id,HttpServletRequest request){
        HttpSession session = request.getSession();
        String si = session.getAttribute("idservice").toString();
        Service s = (Service)session.getAttribute("service");
        model.addAttribute("service", s);
        Integer idservice = Integer.valueOf(si);
        try {
            BonDeCommande b = bonDeCommandeService.getBonDeCommandeByFournisseur(idservice, id);
            bonDeCommandeService.confirmation(b, id);
            // model.addAttribute("bdc", b);
            // System.out.println("1212");
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        return "boncommande";
    }

    @GetMapping("/loginfournisseur")
    public String  loginfournisseur(Model model){

        return "loginfournisseur";
    }

    @GetMapping("/acceuilfournisseur")
    public String acceuilfournisseur(Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("idfournisseur") != null) {
            return "acceuilFournisseur";
        }
        else {
            return "redirect:/loginfournisseur";
        }

    }

    @PostMapping("/veriffournisseur")
    public String veriffournisseur(Model model, HttpServletRequest request, @RequestParam("nom") String nom, @RequestParam("mdp") String mdp) {
        Fournisseur f = fournisseurRepository.getFournisseurByNomAndByMdp(nom,mdp);
        if (f != null) {
            HttpSession session = request.getSession();
            session.setAttribute("idfournisseur",f.getId_fournisseur());

            return "acceuilFournisseur";
        }
        else {
            return "loginfournisseur";
        }
    }

    @GetMapping("/fournisseur/listbesoin")
    public String listbesoin(Model model) {
        List<Service> list = serviceService.getServiceWithBesoin();

        model.addAttribute("listservice",list);

        return "listbesoin";
    }

    @GetMapping("/fournisseur/besoin/{id}")
    public String besoin(Model model,HttpServletRequest request, @PathVariable Integer id) {
        HttpSession session = request.getSession();
        String stringid = session.getAttribute("idfournisseur").toString();
        Integer idfournisseur = Integer.valueOf(stringid);
        List<VerifStock> verifStocks = serviceBesoinService.getVerifStock(id,idfournisseur);

        Service service  = serviceRepository.findById(id).get();

        model.addAttribute("listverifbesoin",verifStocks);
        model.addAttribute("service",service);

        return "verifbesoin";
    }
}
