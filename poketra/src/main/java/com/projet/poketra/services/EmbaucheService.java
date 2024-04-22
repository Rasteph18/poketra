package com.projet.poketra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.poketra.models.Embauche;
import com.projet.poketra.models.Employe;
import com.projet.poketra.repository.EmbaucheRepository;

@Service
public class EmbaucheService {
    
    @Autowired
    private EmbaucheRepository embaucheRepository;

    @Autowired
    private EmployeService employeService;

    @Transactional
    public void insertEmbauche(Employe employe , Embauche embauche)
    {
        int idEmploye = employeService.insertEmploye(employe);

        embauche.setIdEmploye(idEmploye);

        embaucheRepository.save(embauche);
    }
}
