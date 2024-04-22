package com.projet.poketra.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Fabrication {
    
    @Id
    @SequenceGenerator(
        name = "fabrication_sequence",
        sequenceName = "fabrication_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "fabrication_sequence"
    )
    private int id;
    private int idProduit;
    private double quantite;
    private Date dateJour;


    public Fabrication()
    {

    }

    public Fabrication(int id, int idProduit, double quantite, Date dateJour)
    {
        setId(id);
        setIdProduit(idProduit);
        setQuantite(quantite);
        setDateJour(dateJour);
    }

    public Fabrication(int idProduit, double quantite)
    {
        setIdProduit(idProduit);
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
    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    public Date getDateJour() {
        return dateJour;
    }
    public void setDateJour(Date dateJour) {
        this.dateJour = dateJour;
    }

    
}
