package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.Vente;

@Repository
public interface VenteRepository extends JpaRepository<Vente, Integer> {
    
}
