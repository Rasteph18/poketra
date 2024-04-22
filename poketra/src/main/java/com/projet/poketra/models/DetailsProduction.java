package com.projet.poketra.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;

@Entity
public class DetailsProduction {
    
    @Id
    @SequenceGenerator(
        name = "details_production_sequence",
        sequenceName = "details_production_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "details_production_sequence"
    )
    private int id;
    private int idProduit;
    private int idPersonnel;
    private int nbPersonnel;
    private double heureTravail;

    @Transient
    private Personnel personnel;


    public DetailsProduction()
    {

    }

    public DetailsProduction(int id, int idProduit, int idPersonnel, int nbPersonnel, double heureTravail)
    {
        setId(id);
        setIdProduit(idProduit);
        setIdPersonnel(idPersonnel);
        setNbPersonnel(nbPersonnel);
        setHeureTravail(heureTravail);
    }

    public DetailsProduction(int id, int idProduit, Personnel personnel, int nbPersonnel, double heureTravail)
    {
        setId(id);
        setIdProduit(idProduit);
        setPersonnel(personnel);
        setNbPersonnel(nbPersonnel);
        setHeureTravail(heureTravail);
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

    public int getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(int idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    public int getNbPersonnel() {
        return nbPersonnel;
    }

    public void setNbPersonnel(int nbPersonnel) {
        this.nbPersonnel = nbPersonnel;
    }

    public double getHeureTravail() {
        return heureTravail;
    }

    public void setHeureTravail(double heureTravail) {
        this.heureTravail = heureTravail;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }
}
