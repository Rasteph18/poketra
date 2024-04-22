package com.projet.poketra.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "V_details_look")
public class VDetailsLook {
    
    @Id
    private int id;
    private int idLook;
    private int idMatiere;
    private String nomLook;
    private String nomMatiere;

    public VDetailsLook()
    {

    }

    public VDetailsLook(int id, int idLook, int idMatiere, String nomLook, String nomMatiere)
    {
        setId(id);
        setIdLook(idLook);
        setIdMatiere(idMatiere);
        setNomLook(nomLook);
        setNomMatiere(nomMatiere);
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
    public int getIdMatiere() {
        return idMatiere;
    }
    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }
    public String getNomLook() {
        return nomLook;
    }
    public void setNomLook(String nomLook) {
        this.nomLook = nomLook;
    }
    public String getNomMatiere() {
        return nomMatiere;
    }
    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }
}
