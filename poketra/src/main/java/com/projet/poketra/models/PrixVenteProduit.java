package com.projet.poketra.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class PrixVenteProduit {
    
    @Id
    @SequenceGenerator(
        name = "prix_vente_produit_sequence",
        sequenceName = "prix_vente_produit_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "prix_vente_produit_sequence"
    )
    private int id;
    private int idProduit;
    private double prixVente;
    private Date date;


    public PrixVenteProduit()
    {

    }

    public PrixVenteProduit(int id, int idProduit, double prixVente, Date date)
    {
        setId(id);
        setIdProduit(idProduit);
        setPrixVente(prixVente);
        setDate(date);
    }

    public PrixVenteProduit(int id, int idProduit, double prixVente, String date)
    {
        setId(id);
        setIdProduit(idProduit);
        setPrixVente(prixVente);
        setDate(date);
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

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public void setDate(String date) {
        this.date = Date.valueOf(date);
    }

}
