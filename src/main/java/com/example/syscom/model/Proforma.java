package com.example.syscom.model;

import java.util.List;

public class Proforma {
    Fournisseur fournisseur;
    List<Stock_fournisseur> listStock;

    Double Prixtotal;

    public Proforma() {
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public List<Stock_fournisseur> getListStock() {
        return listStock;
    }

    public void setListStock(List<Stock_fournisseur> listStock) {
        this.listStock = listStock;
    }

    public Double getPrixtotal() {
        return Prixtotal;
    }

    public void setPrixtotal(Double prixtotal) {
        Prixtotal = prixtotal;
    }
}
