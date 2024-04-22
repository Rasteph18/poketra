package com.projet.poketra.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Taille {
    
    @Id
    @SequenceGenerator(
        name = "taille_sequence",
        sequenceName = "taille_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "taille_sequence"
    )
    private int id;
    private String nom;
    private int coefficient;

    public Taille()
    {

    }

    public Taille(int id, String nom, int coefficient)
    {
        setId(id);
        setNom(nom);
        setCoefficient(coefficient);
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
}
