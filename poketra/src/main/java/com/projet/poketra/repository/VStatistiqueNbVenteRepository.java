package com.projet.poketra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.poketra.models.VStatistiqueNbVente;
import org.springframework.stereotype.Repository;

@Repository
public interface VStatistiqueNbVenteRepository extends JpaRepository<VStatistiqueNbVente, Integer> {
    
    public List<VStatistiqueNbVente> findByIdProduit(int idProduit);
}
