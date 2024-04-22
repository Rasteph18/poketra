package com.projet.poketra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.poketra.models.Genre;
import com.projet.poketra.repository.GenreRepository;


import java.util.List;

@Service
public class GenreService {
    
    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getAllGenre()
    {
        return genreRepository.findAll();
    }
}
