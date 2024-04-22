package com.projet.poketra.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Client {
    
    @Id
    @SequenceGenerator(
        name = "client_sequence",
        sequenceName = "client_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "client_sequence"
    )
    private int id;
    private String nom;
    private int idGenre;

    public Client()
    {

    }

    public Client(int id, String nom, int idGenre)
    {
        setId(id);
        setNom(nom);
        setIdGenre(idGenre);
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
    public int getIdGenre() {
        return idGenre;
    }
    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }
}
