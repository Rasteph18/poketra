package com.projet.poketra.models;

import java.sql.Date;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Employe {
    
    @Id
    @SequenceGenerator(
        name = "employe_sequence",
        sequenceName = "employe_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "employe_sequence"
    )
    private int id;
    private String nom;
    private String prenom;
    private Date dateNaissance;


    public Employe()
    {

    }

    public Employe(int id, String nom, String prenom, Date dateNaissance)
    {
        setId(id);
        setNom(nom);
        setPrenom(prenom);
        setDateNaissance(dateNaissance);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public Date getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
