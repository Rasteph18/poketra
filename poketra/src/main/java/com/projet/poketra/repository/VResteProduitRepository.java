package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.VResteProduit;

@Repository
public interface VResteProduitRepository extends JpaRepository<VResteProduit, Integer> {
    
    public VResteProduit findByIdProduit(int idProduit);
}
