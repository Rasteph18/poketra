package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.Look;

@Repository
public interface LookRepository extends JpaRepository<Look, Integer> {
    
}
