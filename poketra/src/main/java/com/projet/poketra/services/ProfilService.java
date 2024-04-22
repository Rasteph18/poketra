package com.projet.poketra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.poketra.models.Profil;
import com.projet.poketra.repository.ProfilRepository;

@Service
public class ProfilService {
    
    @Autowired
    private ProfilRepository profilRepository;

    public void insertProfil(Profil profil)
    {
        profilRepository.save(profil);
    }
}
