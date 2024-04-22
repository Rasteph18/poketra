package com.projet.poketra.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Profil {
    
    @Id
    @SequenceGenerator(
        name = "profil_sequence",
        sequenceName = "profil_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "profil_sequence"
    )
    private int id;
    private String nom;
    private int coefficient;
    private int annee;

    public Profil()
    {

    }


    public Profil(int id, String nom, int coefficient, int annee)
    {
        setId(id);
        setNom(nom);
        setCoefficient(coefficient);
        setAnnee(annee);
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
    public int getCoefficient() {
        return coefficient;
    }
    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }
    public int getAnnee() {
        return annee;
    }
    public void setAnnee(int annee) {
        this.annee = annee;
    }


}
