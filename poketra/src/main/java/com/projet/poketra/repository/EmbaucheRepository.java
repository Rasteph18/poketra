package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.Embauche;

@Repository
public interface EmbaucheRepository extends JpaRepository<Embauche, Integer> {
    
}
