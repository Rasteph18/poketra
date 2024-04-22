package com.projet.poketra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.poketra.models.VPrixProduit;
import com.projet.poketra.repository.VPrixProduitRepository;

@Service
public class VPrixProduitService {
    
    @Autowired
    private VPrixProduitRepository vPrixProduitRepository;

    public List<VPrixProduit> getListPrixProduit(double min, double max)
    {
        return vPrixProduitRepository.getAllPrixProduit(min, max);
    }

    public VPrixProduit getPrixProduitByIdProduit(int idProduit)
    {
        return vPrixProduitRepository.findByIdProduit(idProduit);
    }
}
