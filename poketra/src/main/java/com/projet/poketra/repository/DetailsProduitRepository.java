package com.projet.poketra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projet.poketra.models.DetailsProduit;

@Repository
public interface DetailsProduitRepository extends JpaRepository<DetailsProduit, Integer> {
    
    @Query(
        value = "select * from details_produit where id_produit = ?1",
        nativeQuery = true
    )
    public List<DetailsProduit> getDetailsProduitByIdProduit(int idProduit);
}
