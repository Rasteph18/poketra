package com.projet.poketra.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class DureTravailPersonnel {
    
    @Id
    @SequenceGenerator(
        name = "dure_travail_personnel_sequence",
        sequenceName = "dure_travail_personnel_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "dure_travail_personnel_sequence"
    )
    private int id;
    private int idLook;
    private double dure;

    public DureTravailPersonnel()
    {

    }

    public DureTravailPersonnel(int id, int idLook, double dure)
    {
        setId(id);
        setIdLook(idLook);
        setDure(dure);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdLook() {
        return idLook;
    }
    public void setIdLook(int idLook) {
        this.idLook = idLook;
    }
    public double getDure() {
        return dure;
    }
    public void setDure(double dure) {
        this.dure = dure;
    }


}
