package com.projet.poketra.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "V_benefice_produit")
public class VBeneficeProduit {
    
    @Id
    private int idProduit;
    private String taille;
    private String type;
    private String look;
    private double benefice;


    public VBeneficeProduit()
    {

    }

    public VBeneficeProduit(int idProduit, String taille, String type, String look, double benefice)
    {
        setIdProduit(idProduit);
        setTaille(taille);
        setType(type);
        setLook(look);
        setBenefice(benefice);
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
    public double getBenefice() {
        return benefice;
    }
    public void setBenefice(double benefice) {
        this.benefice = benefice;
    }
}
