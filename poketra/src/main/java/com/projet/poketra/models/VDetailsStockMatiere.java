package com.projet.poketra.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "V_details_stock_matiere")
public class VDetailsStockMatiere {
    
    @Id
    private int idMatiere;
    private String nom;
    private double reste;

    public VDetailsStockMatiere()
    {

    }

    public VDetailsStockMatiere(int idMatiere, String nom, double reste)
    {
        setIdMatiere(idMatiere);
        setNom(nom);
        setReste(reste);
    }

    public int getIdMatiere() {
        return idMatiere;
    }
    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public double getReste() {
        return reste;
    }
    public void setReste(double reste) {
        this.reste = reste;
    }
    
}
