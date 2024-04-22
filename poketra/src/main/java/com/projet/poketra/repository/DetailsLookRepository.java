package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.DetailsLook;

@Repository
public interface DetailsLookRepository extends JpaRepository<DetailsLook, Integer> {
    
}
