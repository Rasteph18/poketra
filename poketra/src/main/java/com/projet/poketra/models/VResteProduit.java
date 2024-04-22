package com.projet.poketra.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "V_reste_produit")
public class VResteProduit {
    
    @Id
    private int idProduit;
    private String taille;
    private String type;
    private String look;
    private double quantite;

    public VResteProduit()
    {

    }

    public VResteProduit(int idProduit, String taille, String type, String look, double quantite)
    {
        setIdProduit(idProduit);
        setTaille(taille);
        setType(type);
        setLook(look);
        setQuantite(quantite);
    }


    public int getIdProduit() {
        return idProduit;
    }
    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }
    public String getTaille() {
        return taille;
    }
    public void setTaille(String taille) {
        this.taille = taille;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getLook() {
        return look;
    }
    public void setLook(String look) {
        this.look = look;
    }
    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }


}
