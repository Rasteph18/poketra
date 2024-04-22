package com.projet.poketra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.poketra.models.Matiere;
import com.projet.poketra.repository.MatiereRepository;

@Service
public class MatiereService {
    
    @Autowired
    private MatiereRepository matiereRepository;

    @Transactional
    public void insertMatiere(Matiere matiere)
    {
        matiereRepository.save(matiere);
    }

    public List<Matiere> getAllMatiere()
    {
        return matiereRepository.findAll();
    }

    public Matiere getMatiereById(int id)
    {
        return matiereRepository.findById(Integer.valueOf(id)).get();
    }
}
