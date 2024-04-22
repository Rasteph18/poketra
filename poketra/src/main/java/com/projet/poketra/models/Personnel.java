package com.projet.poketra.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Personnel {
    
    @Id
    @SequenceGenerator(
        name = "personnel_sequence",
        sequenceName = "personnel_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "personnel_sequence"
    )
    private int id;
    private String description;


    public Personnel()
    {

    }

    public Personnel(int id, String description)
    {
        setId(id);
        setDescription(description);
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
