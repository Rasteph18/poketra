package com.projet.poketra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.poketra.models.DureTravailPersonnel;
import com.projet.poketra.models.Personnel;
import com.projet.poketra.repository.DureTravailPersonnelRepository;
import com.projet.poketra.repository.PersonnelRepository;

@Service
public class PersonnelService {
    
    @Autowired
    private PersonnelRepository personnelRepository;

    @Autowired
    private DureTravailPersonnelRepository dureTravailPersonnelRepository;

    public void insertPersonnel(Personnel personnel)
    {
        personnelRepository.save(personnel);
    }

    public List<Personnel> getAllPersonnel()
    {
        return personnelRepository.findAll();
    }

    public Personnel getById(int id)
    {
        return personnelRepository.findById(id).get();
    }

    public void insertDureTravailPersonnel(DureTravailPersonnel dureTravailPersonnel)
    {
        dureTravailPersonnelRepository.save(dureTravailPersonnel);
    }
}
