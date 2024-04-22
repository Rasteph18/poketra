package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.VStatistiqueNbVenteAll;

@Repository
public interface VStatistiqueNbVenteAllRepository extends JpaRepository<VStatistiqueNbVenteAll, Integer> {
    
}
