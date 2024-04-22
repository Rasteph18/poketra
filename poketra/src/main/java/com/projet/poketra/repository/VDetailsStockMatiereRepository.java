package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.VDetailsStockMatiere;

@Repository
public interface VDetailsStockMatiereRepository extends JpaRepository<VDetailsStockMatiere, Integer> {
    
}
