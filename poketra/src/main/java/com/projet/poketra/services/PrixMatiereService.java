package com.projet.poketra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.poketra.models.PrixMatiere;
import com.projet.poketra.repository.PrixMatiereRepository;

@Service
public class PrixMatiereService {
    
    @Autowired
    private PrixMatiereRepository prixMatiereRepository;

    public void insertPrixMatiere(PrixMatiere prixMatiere)
    {
        prixMatiereRepository.save(prixMatiere);
    }
}
