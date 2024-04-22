package com.projet.poketra.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "V_prix_personnel_production")
public class VPrixPersonnelProduction {
    
    @Id
    private int idProduit;
    private double prix;

    public VPrixPersonnelProduction()
    {

    }

    public VPrixPersonnelProduction(int idProduit, double prix)
    {
        setIdProduit(idProduit);
        setPrix(prix);
    }


    public int getIdProduit() {
        return idProduit;
    }
    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
}
