package com.example.syscom.service;

import com.example.syscom.model.Immobilisations;
import com.example.syscom.repository.ImmobilisationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LineaireService {
    @Autowired
    ImmobilisationsRepository immobilisationsRepository;

    public List<Immobilisations> calcule_lineaire(Integer id_immobilisation) {
        List<Immobilisations> valiny = new ArrayList<>();
        Immobilisations immob = immobilisationsRepository.findById(id_immobilisation).get();
        double dota = immob.getPrix() / this.annee(immob.getTaux_amortissement());
//        System.out.println(this.annee(immob.getTaux_amortissement()));

        double am_debut_periode = 0.0;
        double am_fin_periode = am_debut_periode + dota;
        double valeur_net = immob.getPrix() - am_fin_periode;

        for (int i = 0; i < this.annee(immob.getTaux_amortissement()); i++) {
            Immobilisations vaovao = new Immobilisations();
//            vaovao = immob;
            vaovao.setPrix(immob.getPrix());
            vaovao.setTaux_amortissement(immob.getTaux_amortissement());

            vaovao.setAm_debut_periode(am_debut_periode);
            vaovao.setDotation(dota);
            vaovao.setAm_fin_periode(am_fin_periode);
            vaovao.setValeur_net_comptable(valeur_net);
            valiny.add(vaovao);

            am_debut_periode = am_fin_periode;
            System.out.println("debut "+vaovao.getAm_debut_periode());
            am_fin_periode = am_fin_periode + dota;
            System.out.println("fin ");
            valeur_net = immob.getPrix() - am_fin_periode;
            System.out.println("net ");
        }

        return valiny;
    }

    public int annee(double taux) {
        int valiny = 0;
        double plus = taux;

        while (taux <= 100) {
            valiny++;
//            System.out.println("taux" +taux);
            taux += plus;
        }

        return valiny;
    }
}
