package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.Matiere;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Integer> {
    
}
