package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.Personnel;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {
    
}
