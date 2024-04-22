package com.projet.poketra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.poketra.models.VDetailsStockMatiere;
import com.projet.poketra.repository.VDetailsStockMatiereRepository;

@Service
public class VDetailsStockMatiereService {
    
    @Autowired
    private VDetailsStockMatiereRepository vDetailsStockMatiereRepository;

    public List<VDetailsStockMatiere> getDetailsStockMatiere()
    {
        return vDetailsStockMatiereRepository.findAll();
    }

}
