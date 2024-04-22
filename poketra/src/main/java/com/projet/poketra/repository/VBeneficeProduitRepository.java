package com.projet.poketra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.VBeneficeProduit;

@Repository
public interface VBeneficeProduitRepository extends JpaRepository<VBeneficeProduit, Integer> {
    
    public List<VBeneficeProduit> findByBeneficeBetween(double min, double max);
}
