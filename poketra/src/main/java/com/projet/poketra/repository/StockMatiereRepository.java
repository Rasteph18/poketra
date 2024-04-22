package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.StockMatiere;

@Repository
public interface StockMatiereRepository extends JpaRepository<StockMatiere, Integer> {
    
    @Query(
        value = "SELECT SUM(quantite_entre) - SUM(quantite_sorti) AS quantite FROM stock_matiere WHERE id_matiere = ?1",
        nativeQuery = true
    )
    public double resteEnStock(int idMatiere);
}
