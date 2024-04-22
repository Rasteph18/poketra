package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.NbPersonnelTaille;

@Repository
public interface NbPersonnelTailleRepository extends JpaRepository<NbPersonnelTaille, Integer> {
    
    @Query(
        value = "select * from nb_personnel_taille ORDER BY date_jour DESC limit 1",
        nativeQuery = true
    )
    public NbPersonnelTaille getLastNbPersonnelTaille();
}
