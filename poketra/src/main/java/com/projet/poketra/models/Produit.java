package com.projet.poketra.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Produit {
    
    @Id
    @SequenceGenerator(
        name = "produit_sequence",
        sequenceName = "produit_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "produit_sequence"
    )
    private int id;
    private int idType;
    private int idLook;
    private int idTaille;

    public Produit()
    {

    }

    public Produit(int id, int idType, int idLook, int idTaille)
    {
        setId(id);
        setIdType(idType);
        setIdLook(idLook);
        setIdTaille(idTaille);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdType() {
        return idType;
    }
    public void setIdType(int idType) {
        this.idType = idType;
    }
    public int getIdLook() {
        return idLook;
    }
    public void setIdLook(int idLook) {
        this.idLook = idLook;
    }
    public int getIdTaille() {
        return idTaille;
    }
    public void setIdTaille(int idTaille) {
        this.idTaille = idTaille;
    }
}
