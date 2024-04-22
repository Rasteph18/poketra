package com.projet.poketra.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.poketra.repository.VDetailsEmployeRepository;

import com.projet.poketra.models.VProfilEmploye;

@Service
public class VDetailsEmployeService {
    
    @Autowired
    private VDetailsEmployeRepository vDetailsEmployeRepository;

    public List<VProfilEmploye> getAllDetailsEmploye()
    {
        return vDetailsEmployeRepository.findAll();
    }
}
