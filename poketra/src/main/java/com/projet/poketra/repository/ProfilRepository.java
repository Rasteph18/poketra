package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.Profil;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Integer> {
    
}
