package com.projet.poketra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.poketra.models.VStatistiqueNbVente;
import com.projet.poketra.models.VStatistiqueNbVenteAll;
import com.projet.poketra.repository.VStatistiqueNbVenteAllRepository;
import com.projet.poketra.repository.VStatistiqueNbVenteRepository;

@Service
public class VStatistiqueNbVenteService {
    
    @Autowired
    private VStatistiqueNbVenteRepository vStatistiqueNbVenteRepository;

    @Autowired
    private VStatistiqueNbVenteAllRepository vStatistiqueNbVenteAllRepository;

    public List<VStatistiqueNbVente> getAllStatistiqueNbVente()
    {
        return vStatistiqueNbVenteRepository.findAll();
    }

    public List<VStatistiqueNbVente> getStatByIdProduit(String idProduit)
    {
        return vStatistiqueNbVenteRepository.findByIdProduit(Integer.parseInt(idProduit));
    }

    public List<VStatistiqueNbVenteAll> getStatOfAllVente()
    {
        return vStatistiqueNbVenteAllRepository.findAll();
    }
}
