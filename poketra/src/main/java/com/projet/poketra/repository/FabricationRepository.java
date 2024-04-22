package com.projet.poketra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.Fabrication;

@Repository
public interface FabricationRepository extends JpaRepository<Fabrication, Integer> {
    
    @Query(
        value = "UPDATE fabrication SET quantite = ?1 WHERE id_produit = ?2",
        nativeQuery = true
    )
    public void updateFabricationByIdProduit(double quantite ,int idProduit);

    @Query(
        value = "select id_produit, SUM(quantite) AS quantite from fabrication WHERE id_produit = ?1 GROUP BY id_produit",
        nativeQuery = true
    )
    public Fabrication getResteProduitByIdProduit(int idProduit);
}
