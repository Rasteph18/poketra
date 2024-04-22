package com.projet.poketra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.poketra.repository.VBeneficeProduitRepository;
import com.projet.poketra.models.VBeneficeProduit;

@Service
public class VBeneficeProduitService {
    
    @Autowired
    private VBeneficeProduitRepository vBeneficeProduitRepository;

    public List<VBeneficeProduit> getAllBeneficeBetween(double min, double max)
    {
        return vBeneficeProduitRepository.findByBeneficeBetween(min, max);
    }
}
