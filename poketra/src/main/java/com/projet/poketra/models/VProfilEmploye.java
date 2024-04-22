package com.projet.poketra.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "V_profil_employe")
public class VProfilEmploye {
    
    @Id
    private int idEmploye;
    private String nomEmploye;
    private String prenomEmploye;
    private Date dateNaissance;
    private int anneeExperience;
    private String description;
    private Date dateEmbauche;
    private String nomProfil;
    private double salaire;

    public VProfilEmploye()
    {

    }

    public VProfilEmploye(int idEmploye, String nomEmploye, String prenomEmploye, Date dateNaissance, int anneeExperience, String description, Date dateEmbauche, String nomProfil, double salaire)
    {
        setIdEmploye(idEmploye);
        setNomEmploye(nomEmploye);
        setPrenomEmploye(prenomEmploye);
        setDateNaissance(dateNaissance);
        setAnneeExperience(anneeExperience);
        setDescription(description);
        setDateEmbauche(dateEmbauche);
        setNomProfil(nomProfil);
        setSalaire(salaire);
    }


    public int getIdEmploye() {
        return idEmploye;
    }
    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }
    public String getNomEmploye() {
        return nomEmploye;
    }
    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }
    public String getPrenomEmploye() {
        return prenomEmploye;
    }
    public void setPrenomEmploye(String prenomEmploye) {
        this.prenomEmploye = prenomEmploye;
    }
    public Date getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public int getAnneeExperience() {
        return anneeExperience;
    }
    public void setAnneeExperience(int anneeExperience) {
        this.anneeExperience = anneeExperience;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getDateEmbauche() {
        return dateEmbauche;
    }
    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }
    public String getNomProfil() {
        return nomProfil;
    }
    public void setNomProfil(String nomProfil) {
        this.nomProfil = nomProfil;
    }
    public double getSalaire() {
        return salaire;
    }
    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
}
