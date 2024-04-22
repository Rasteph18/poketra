package com.projet.poketra.services;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.poketra.models.PrixVenteProduit;
import com.projet.poketra.repository.PrixVenteProduitRepository;

@Service
public class PrixVenteProduitService {
    
    @Autowired
    private PrixVenteProduitRepository prixVenteProduitRepository;

    @Autowired
    private ProduitService produitService;

    @Transactional
    public void insertPrixVenteProduit(PrixVenteProduit prixVenteProduit) throws Exception
    {
        LocalDate currentDate = LocalDate.now();
        prixVenteProduit.setDate(Date.valueOf(currentDate));

        double prixRevient = produitService.prixRevient(prixVenteProduit.getIdProduit());

        if(prixRevient > prixVenteProduit.getPrixVente()) {
            throw new Exception("Le prix de vente est inférieure au prix de revient");
        }

        prixVenteProduitRepository.save(prixVenteProduit);
    }
}
