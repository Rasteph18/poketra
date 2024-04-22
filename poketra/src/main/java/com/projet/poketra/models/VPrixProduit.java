package com.projet.poketra.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "V_prix_produit")
public class VPrixProduit {
    
    @Id
    private int idProduit;
    private double prix;
    private String type;
    private String taille;
    private String look;

    public VPrixProduit()
    {

    }

    public VPrixProduit(int idProduit, double prix, String type, String taille, String look)
    {
        setIdProduit(idProduit);
        setPrix(prix);
        setType(type);
        setTaille(taille);
        setLook(look);
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
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getTaille() {
        return taille;
    }
    public void setTaille(String taille) {
        this.taille = taille;
    }
    public String getLook() {
        return look;
    }
    public void setLook(String look) {
        this.look = look;
    }
}
