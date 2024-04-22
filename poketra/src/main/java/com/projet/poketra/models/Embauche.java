package com.projet.poketra.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Embauche {
    
    @Id
    @SequenceGenerator(
        name = "embauche_sequence",
        sequenceName = "embauche_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "embauche_sequence"
    )
    private int id;
    private int idEmploye;
    private Date dateEmbauche;
    private int idPersonnel;


    public Embauche()
    {

    }

    public Embauche(int id, int idEmploye, Date dateEmbauche, int idPersonnel)
    {
        setId(id);
        setIdEmploye(idEmploye);
        setDateEmbauche(dateEmbauche);
        setIdPersonnel(idPersonnel);
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdEmploye() {
        return idEmploye;
    }
    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }
    public Date getDateEmbauche() {
        return dateEmbauche;
    }
    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }
    public int getIdPersonnel() {
        return idPersonnel;
    }
    public void setIdPersonnel(int idPersonnel) {
        this.idPersonnel = idPersonnel;
    }


}
