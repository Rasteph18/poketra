package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.Taille;

@Repository
public interface TailleRepository extends JpaRepository<Taille, Integer> {
    
    @Query(
        value = "select * from taille ORDER by coefficient asc, id desc limit 1",
        nativeQuery = true
    )
    public Taille getTailleLePlusPetit();
}
