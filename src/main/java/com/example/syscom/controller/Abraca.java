package com.example.syscom.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Abraca {

    @GetMapping("/login")
    public String login(Model model) {

        return "login";
    }

    @PostMapping("/dash")
    public String dash(Model model) {

        return "index";
    }

    @GetMapping("/dash")
    public String dashi(Model model) {

        return "index";
    }

    @GetMapping("/besoin")
    public String besoin(Model model) {

        return "besoin";
    }

    @GetMapping("/listproforma")
    public String list(Model model) {

        return "proformalist";
    }

    @GetMapping("/proforma")
    public String proforma(Model model) {

        return "proforma";
    }

    @GetMapping("/bclist")
    public String bclist(Model model) {

        return "boncommandelist";
    }

    @GetMapping("/boncommande")
    public String bc(Model model) {

        return "boncommande";
    }
}
