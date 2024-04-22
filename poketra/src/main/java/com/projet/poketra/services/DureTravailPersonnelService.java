package com.projet.poketra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.poketra.models.DureTravailPersonnel;
import com.projet.poketra.repository.DureTravailPersonnelRepository;

@Service
public class DureTravailPersonnelService {
    
    @Autowired
    private DureTravailPersonnelRepository dureTravailPersonnelRepository;

    public void insertDureTravailPersonnel(DureTravailPersonnel dureTravailPersonnel)
    {
        dureTravailPersonnelRepository.save(dureTravailPersonnel);
    }


    public DureTravailPersonnel getByIdlook(int idLook)
    {
        return dureTravailPersonnelRepository.findByIdLook(idLook);
    }
}
