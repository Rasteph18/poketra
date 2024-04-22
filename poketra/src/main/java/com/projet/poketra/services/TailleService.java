package com.projet.poketra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.poketra.models.NbPersonnelTaille;
import com.projet.poketra.models.Taille;
import com.projet.poketra.repository.NbPersonnelTailleRepository;
import com.projet.poketra.repository.TailleRepository;

@Service
public class TailleService {
    
    @Autowired
    private TailleRepository tailleRepository;

    @Autowired
    private NbPersonnelTailleRepository nbPersonnelTailleRepository;

    public void insertTaille(Taille taille) throws Exception
    {
        tailleRepository.save(taille);
    }

    public List<Taille> getAllTaille() throws Exception {
        return tailleRepository.findAll();
    }

    public void insertNbPersonneTaille(NbPersonnelTaille nbPersonnelTaille)
    {
        nbPersonnelTailleRepository.save(nbPersonnelTaille);
    }

    public Taille tailleLePlusPetit()
    {
        return tailleRepository.getTailleLePlusPetit();
    }

    public Taille getTailleById(int id)
    {
        return tailleRepository.findById(id).get();
    }
}
