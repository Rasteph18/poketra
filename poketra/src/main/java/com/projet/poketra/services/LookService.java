package com.projet.poketra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.poketra.models.Look;
import com.projet.poketra.repository.LookRepository;

@Service
public class LookService {
    
    @Autowired
    private LookRepository lookRepository;

    @Transactional
    public void insertLook(Look look) {
        lookRepository.save(look);
    }

    public List<Look> getAllLook()
    {
        return lookRepository.findAll();
    }

    public Look getLookById(int id)
    {
        return lookRepository.findById(Integer.valueOf(id)).get();
    }
}
