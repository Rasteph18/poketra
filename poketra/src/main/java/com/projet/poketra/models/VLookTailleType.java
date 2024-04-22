package com.projet.poketra.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "V_look_taille_type")
public class VLookTailleType {
    
    @Id
    private int idProduit;
    private int idMatiere;
    private String taille;
    private String type;
    private String look;
    private double quantite;

    public VLookTailleType()
    {
        
    }

    public VLookTailleType(int idProduit, int idMatiere, String taille, String type, String look, double quantite)
    {
        setIdProduit(idProduit);
        setIdMatiere(idMatiere);
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

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
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

    @Override
    public String toString() {
        return "VLookTailleType [idProduit=" + idProduit + ", idMatiere=" + idMatiere + ", taille=" + taille + ", type=" + type
                + ", look=" + look + ", quantite=" + quantite + "]";
    }
    
}
