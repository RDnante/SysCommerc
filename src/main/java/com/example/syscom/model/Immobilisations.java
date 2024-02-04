package com.example.syscom.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "immobilisations")
public class Immobilisations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_immobilisation;
    @Column
    Date date;
    @Column
    Double prix;
    @Column
    String compte_comptable;
    @Column
    Integer numero;
    @Column
    String type;
    @Column
    String marque;
    @Column
    String modele;
    @Column
    String numero_serie;
    @Column
    String description;
    @Column
    Double taux_ammortissement;
    @Column
    Boolean neuf;
    @Column
    Boolean utilisation;
    @Column
    String methode_amortissemt;
    @Column
    Integer id_lieu;

    @Transient
    Double am_debut_periode;
    @Transient
    Double Dotation;
    @Transient
    Double am_fin_periode;
    @Transient
    Double valeur_net_comptable;


}
