package com.projet.poketra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.poketra.models.VResteProduit;
import com.projet.poketra.models.Vente;
import com.projet.poketra.repository.VResteProduitRepository;
import com.projet.poketra.repository.VenteRepository;

@Service
public class VenteService {
    
    @Autowired
    private VenteRepository venteRepository;

    @Autowired
    private FabricationService fabricationService;

    @Autowired
    private VResteProduitRepository vResteProduitRepository;

    @Transactional
    public void insertVente(Vente vente) throws Exception
    {
        VResteProduit resteProduit = vResteProduitRepository.findByIdProduit(vente.getIdProduit());
        if(resteProduit.getQuantite() < vente.getQuantite()) {
            throw new Exception("Quantité produit en stock insuffisant");
        } else {
            double quantiteEnleve = -1 * vente.getQuantite();
            fabricationService.insertSortiFabrication(vente.getIdProduit(), quantiteEnleve);

            venteRepository.save(vente);
        }
    }
}
