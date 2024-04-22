package com.projet.poketra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.VDetailsLook;

@Repository
public interface VDetailsLookRepository extends JpaRepository<VDetailsLook, Integer> {
    
    public List<VDetailsLook> findByIdLookOrderByNomMatiere(Integer id);
}
