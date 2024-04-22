package com.projet.poketra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.poketra.models.DetailsLook;
import com.projet.poketra.repository.DetailsLookRepository;

@Service
public class DetailsLookService {
    
    @Autowired
    private DetailsLookRepository detailsLookRepository;


    @Transactional
    public void insertDetailsLook(String idLook, String[] idMatiere) throws Exception
    {
        int look = Integer.parseInt(idLook);

        for(int i = 0; i < idMatiere.length; i++)
        {
            int matiere = Integer.parseInt(idMatiere[i]);
            DetailsLook detailsLook = new DetailsLook();
            detailsLook.setIdLook(look);
            detailsLook.setIdMatiere(matiere);


            detailsLookRepository.save(detailsLook);
        }
    }
}
