package com.projet.poketra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.poketra.models.VDetailsLook;
import com.projet.poketra.repository.VDetailsLookRepository;

@Service
public class VDetailsLookService {
    
    @Autowired
    private VDetailsLookRepository vDetailsLookRepository;

    public List<VDetailsLook> getDetailsLookByIdLookOrderByNomMatiere(int id)
    {
        return vDetailsLookRepository.findByIdLookOrderByNomMatiere(Integer.valueOf(id));
    }
}
