package com.projet.poketra.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class SalairePersonnel {
    
    @Id
    @SequenceGenerator(
        name = "salaire_personnel_sequence",
        sequenceName = "salaire_personnel_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "salaire_personnel_sequence"
    )
    private int id;
    private int idPersonnel;
    private double salaire;
    private Date date;


    public SalairePersonnel()
    {

    }

    public SalairePersonnel(int id, int idPersonnel, double salaire, Date date)
    {
        setId(id);
        setIdPersonnel(idPersonnel);
        setSalaire(salaire);
        setDate(date);
    }

    public SalairePersonnel(int id, int idPersonnel, double salaire, String date)
    {
        setId(id);
        setIdPersonnel(idPersonnel);
        setSalaire(salaire);
        setDate(date);
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdPersonnel() {
        return idPersonnel;
    }
    public void setIdPersonnel(int idPersonnel) {
        this.idPersonnel = idPersonnel;
    }
    public double getSalaire() {
        return salaire;
    }
    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setDate(String date) {
        this.date = Date.valueOf(date);
    }
}
