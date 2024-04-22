package com.projet.poketra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.VLookTailleType;

@Repository
public interface VLookTailleTypeRepository extends JpaRepository<VLookTailleType, Integer> {
    
    public List<VLookTailleType> findByIdMatiere(int idMatiere);
}
