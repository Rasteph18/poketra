package com.projet.poketra.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Genre {
    
    @Id
    @SequenceGenerator(
        name = "genre_sequence",
        sequenceName = "genre_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "genre_sequence"
    )
    private int id;
    private String description;


    public Genre()
    {

    }

    public Genre(int id, String description)
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
