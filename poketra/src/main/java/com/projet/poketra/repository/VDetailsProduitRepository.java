package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.VDetailsProduit;

@Repository
public interface VDetailsProduitRepository extends JpaRepository<VDetailsProduit, Integer> {
    
    public VDetailsProduit findByIdProduit(int idProduit);
}
