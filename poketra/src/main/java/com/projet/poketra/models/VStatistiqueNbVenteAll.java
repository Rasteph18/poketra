package com.projet.poketra.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "V_statistique_nb_vente_all")
public class VStatistiqueNbVenteAll {
    
    @Id
    private int id;
    private int idGenre;
    private String description;
    private int nombre;

    public VStatistiqueNbVenteAll()
    {

    }

    public VStatistiqueNbVenteAll(int id, int idGenre, String description, int nombre)
    {
        setId(id);
        setIdGenre(idGenre);
        setDescription(description);
        setNombre(nombre);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    
}
