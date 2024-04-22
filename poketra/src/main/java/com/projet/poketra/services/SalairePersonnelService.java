package com.projet.poketra.services;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.poketra.models.SalairePersonnel;
import com.projet.poketra.repository.SalairePersonnelRepository;

@Service
public class SalairePersonnelService {
    
    @Autowired
    private SalairePersonnelRepository salairePersonnelRepository;

    public void insertSalairePersonnel(SalairePersonnel salairePersonnel)
    {
        if(salairePersonnel.getDate() == null) {
            Calendar calendar = Calendar.getInstance();
            java.util.Date currentDate = calendar.getTime();
            Date sqlDate = new Date(currentDate.getTime());

            salairePersonnel.setDate(sqlDate);
        }
        salairePersonnelRepository.save(salairePersonnel);
    }
}
