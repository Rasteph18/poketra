package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.SalairePersonnel;

@Repository
public interface SalairePersonnelRepository extends JpaRepository<SalairePersonnel, Integer> {
    
}
