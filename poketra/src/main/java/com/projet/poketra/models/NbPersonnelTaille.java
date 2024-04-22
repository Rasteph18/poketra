package com.projet.poketra.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class NbPersonnelTaille {
    
    @Id
    @SequenceGenerator(
        name = "nb_personnel_taille_sequence",
        sequenceName = "nb_personnel_taille_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "nb_personnel_taille_sequence"
    )
    private int id;
    private int idTaille;
    private int nbPersonnel;
    private int coeffTaille;
    private Date dateJour;


    public NbPersonnelTaille()
    {

    }

    public NbPersonnelTaille(int id, int idTaille, int nbPersonnel, int coeffTaille, Date dateJour)
    {
        setId(id);
        setIdTaille(idTaille);
        setNbPersonnel(nbPersonnel);
        setCoeffTaille(coeffTaille);
        setDateJour(dateJour);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdTaille() {
        return idTaille;
    }
    public void setIdTaille(int idTaille) {
        this.idTaille = idTaille;
    }
    public int getNbPersonnel() {
        return nbPersonnel;
    }
    public void setNbPersonnel(int nbPersonnel) {
        this.nbPersonnel = nbPersonnel;
    }
    public int getCoeffTaille() {
        return coeffTaille;
    }
    public void setCoeffTaille(int coeffTaille) {
        this.coeffTaille = coeffTaille;
    }
    public Date getDateJour() {
        return dateJour;
    }
    public void setDateJour(Date dateJour) {
        this.dateJour = dateJour;
    }
}
