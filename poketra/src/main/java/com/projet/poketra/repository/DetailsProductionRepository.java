package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.DetailsProduction;

@Repository
public interface DetailsProductionRepository extends JpaRepository<DetailsProduction, Integer> {
    
}
