package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.VPrixPersonnelProduction;

@Repository
public interface VPrixPersonnelProductionRepository extends JpaRepository<VPrixPersonnelProduction, Integer> {
    
    public VPrixPersonnelProduction findByIdProduit(int idProduit);
}
