package com.projet.poketra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.poketra.models.VProfilEmploye;
import com.projet.poketra.repository.VProfilEmployeRepository;

@Service
public class VProfilEmployeService {
    
    @Autowired
    private VProfilEmployeRepository vProfilEmployeRepository;

    public List<VProfilEmploye> getAllProfilEmploye()
    {
        return vProfilEmployeRepository.findAll();
    }
}
