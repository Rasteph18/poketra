package com.projet.poketra.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projet.poketra.models.VResteProduit;
import com.projet.poketra.repository.VResteProduitRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class VResteProduitService {
    
    @Autowired
    private VResteProduitRepository vResteProduitRepository;

    public List<VResteProduit> getAllResteProduit()
    {
        return vResteProduitRepository.findAll();
    }
}
