package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.DureTravailPersonnel;

@Repository
public interface DureTravailPersonnelRepository extends JpaRepository<DureTravailPersonnel, Integer> {
    
    public DureTravailPersonnel findByIdLook(int idLook);
}
