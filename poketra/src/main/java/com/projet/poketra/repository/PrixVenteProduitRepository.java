package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.PrixVenteProduit;

@Repository
public interface PrixVenteProduitRepository extends JpaRepository<PrixVenteProduit, Integer> {
    
}
