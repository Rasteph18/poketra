package com.projet.poketra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.poketra.models.VDetailsProduit;
import com.projet.poketra.repository.VDetailsProduitRepository;

@Service
public class VDetailsProduitService {
    
    @Autowired
    private VDetailsProduitRepository vDetailsProduitRepository;

    public List<VDetailsProduit> getDetailsProduit()
    {
        return vDetailsProduitRepository.findAll();
    }

    public VDetailsProduit getDetailsProduitByIdProduit(String idProduit)
    {
        return vDetailsProduitRepository.findByIdProduit(Integer.parseInt(idProduit));
    }
}
