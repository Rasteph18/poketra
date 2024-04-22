package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.VProfilEmploye;

@Repository
public interface VProfilEmployeRepository extends JpaRepository<VProfilEmploye, Integer> {
    
}
