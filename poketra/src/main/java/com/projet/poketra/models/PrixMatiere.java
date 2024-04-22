package com.projet.poketra.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class PrixMatiere {
    
    @Id
    @SequenceGenerator(
        name = "prix_matiere_sequence",
        sequenceName = "prix_matiere_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "prix_matiere_sequence"
    )
    private int id;
    private int idMatiere;
    private Date dateJour;
    private double prix;

    public PrixMatiere()
    {

    }

    public PrixMatiere(int id, int idMatiere, Date dateJour, double prix) throws Exception
    {
        setId(id);
        setIdMatiere(idMatiere);
        setDateJour(dateJour);
        setPrix(prix);
    }

    public PrixMatiere(int id, int idMatiere, String dateJour, double prix) throws Exception
    {
        setId(id);
        setIdMatiere(idMatiere);
        setDateJour(dateJour);
        setPrix(prix);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdMatiere() {
        return idMatiere;
    }
    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }
    public Date getDateJour() {
        return dateJour;
    }
    public void setDateJour(Date dateJour) {
        this.dateJour = dateJour;
    }
    public void setDateJour(String dateJour) {
        this.dateJour = Date.valueOf(dateJour);
        
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) throws Exception {
        if (prix < 0) {
            throw new Exception("Valeur invalide");
        }
        this.prix = prix;
    }


}
