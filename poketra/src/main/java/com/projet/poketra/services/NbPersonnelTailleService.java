package com.projet.poketra.services;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.poketra.models.NbPersonnelTaille;
import com.projet.poketra.repository.NbPersonnelTailleRepository;

@Service
public class NbPersonnelTailleService {
    
    @Autowired
    private NbPersonnelTailleRepository nbPersonnelTailleRepository;

    public void insertNbPersonneTaille(NbPersonnelTaille nbPersonnelTaille)
    {
        LocalDate currentDate = LocalDate.now();
        nbPersonnelTaille.setDateJour(Date.valueOf(currentDate));
        nbPersonnelTailleRepository.save(nbPersonnelTaille);
    }

    public NbPersonnelTaille getLastNbPersonnelTaille()
    {
        return nbPersonnelTailleRepository.getLastNbPersonnelTaille();
    }
}
