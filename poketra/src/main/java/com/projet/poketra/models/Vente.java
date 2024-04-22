package com.projet.poketra.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Vente {
    
    @Id
    @SequenceGenerator(
        name = "vente_sequence",
        sequenceName = "vente_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "vente_sequence"
    )
    private int id;
    private int idProduit;
    private int quantite;
    private Date dateVente;
    private int idClient;


    public Vente()
    {

    }

    public Vente(int id, int idProduit, int quantite, Date dateVente, int idClient)
    {
        setId(id);
        setIdProduit(idProduit);
        setQuantite(quantite);
        setDateVente(dateVente);
        setIdClient(idClient);
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
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public Date getDateVente() {
        return dateVente;
    }
    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }
    public int getIdClient() {
        return idClient;
    }
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}
