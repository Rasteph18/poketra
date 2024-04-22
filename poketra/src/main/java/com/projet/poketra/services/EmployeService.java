package com.projet.poketra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.poketra.repository.EmployeRepository;

import com.projet.poketra.models.Employe;

@Service
public class EmployeService {
    
    @Autowired
    private EmployeRepository employeRepository;

    public int insertEmploye(Employe employe)
    {
        return employeRepository.save(employe).getId();
    }
}
