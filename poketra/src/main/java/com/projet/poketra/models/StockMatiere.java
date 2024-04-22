package com.projet.poketra.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class StockMatiere {
    
    @Id
    @SequenceGenerator(
        name = "stock_matiere_sequence",
        sequenceName = "stock_matiere_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "stock_matiere_sequence"
    )
    private int id;
    private int idMatiere;
    private double quantiteEntre;
    private double quantiteSorti;
    private Date dateJour;

    public StockMatiere()
    {

    }

    public StockMatiere(int id, int idMatiere, double quantiteEntre, double quantiteSorti, Date dateJour)
    {
        setId(id);
        setIdMatiere(idMatiere);
        setQuantiteEntre(quantiteEntre);
        setQuantiteSorti(quantiteSorti);
        setDateJour(dateJour);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdMatiere() {
        return idMatiere;
    }
    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }
    public double getQuantiteEntre() {
        return quantiteEntre;
    }
    public void setQuantiteEntre(double quantiteEntre) {
        this.quantiteEntre = quantiteEntre;
    }
    public double getQuantiteSorti() {
        return quantiteSorti;
    }
    public void setQuantiteSorti(double quantiteSorti) {
        this.quantiteSorti = quantiteSorti;
    }
    public Date getDateJour() {
        return dateJour;
    }
    public void setDateJour(Date dateJour) {
        this.dateJour = dateJour;
    }

    
}
