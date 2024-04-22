package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
    
}