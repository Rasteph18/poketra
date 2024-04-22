package com.projet.poketra.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "details_look")
public class DetailsLook {
    
    @Id
    @SequenceGenerator(
        name = "details_look_sequence",
        sequenceName = "details_look_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "details_look_sequence"
    )
    private int id;

    @Column(name = "id_look")
    private int idLook;

    @Column(name = "id_matiere")
    private int idMatiere;

    public DetailsLook()
    {

    }

    public DetailsLook(int id, int idLook, int idMatiere)
    {
        setId(id);
        setIdLook(idLook);
        setIdMatiere(idMatiere);
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

}
