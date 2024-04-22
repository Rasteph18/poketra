package com.projet.poketra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.VPrixProduit;

@Repository
public interface VPrixProduitRepository extends JpaRepository<VPrixProduit, Integer> {
    
    @Query(
        value = "SELECT * FROM V_prix_produit WHERE prix >= ?1 AND prix <= ?2",
        nativeQuery = true
    )
    public List<VPrixProduit> getAllPrixProduit(double min, double max);


    public VPrixProduit findByIdProduit(int idProduit);
}
