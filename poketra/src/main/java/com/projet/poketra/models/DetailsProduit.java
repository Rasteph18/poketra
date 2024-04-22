package com.projet.poketra.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class DetailsProduit {
    
    @Id
    @SequenceGenerator(
        name = "details_produit_sequence",
        sequenceName = "details_produit_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "details_produit_sequence"
    )
    private int id;
    private int idProduit;
    private int idMatiere;
    private double quantite;

    public DetailsProduit()
    {

    }

    public DetailsProduit(int id, int idProduit, int idMatiere, double quantite) throws Exception
    {
        setId(id);
        setIdProduit(idProduit);
        setIdMatiere(idMatiere);
        setQuantite(quantite);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(double quantite) throws Exception {
        if(quantite < 0)
        {
            throw new Exception("Valeur invalide!");
        }
        this.quantite = quantite;
    }


}
