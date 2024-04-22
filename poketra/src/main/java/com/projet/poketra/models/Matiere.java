package com.projet.poketra.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Matiere {
    
    @Id
    @SequenceGenerator(
        name = "matiere_sequence",
        sequenceName = "matiere_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "matiere_sequence"
    )
    private int id;
    private String nom;

    public Matiere()
    {

    }

    public Matiere(int id, String nom)
    {
        setId(id);
        setNom(nom);
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

}
