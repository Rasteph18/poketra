package com.projet.poketra.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.poketra.models.PrixVenteProduit;
import com.projet.poketra.models.Produit;
import com.projet.poketra.repository.PrixVenteProduitRepository;
import com.projet.poketra.repository.ProduitRepository;
import com.projet.poketra.repository.VPrixPersonnelProductionRepository;

@Service
public class ProduitService {
    
    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private PrixVenteProduitRepository prixVenteProduitRepository;

    @Autowired
    private VPrixPersonnelProductionRepository vPrixPersonnelProductionRepository;

    @Autowired
    private VPrixProduitService vPrixProduitService;

    public int insertProduit(Produit produit) throws Exception
    {
        int idProduit = produitRepository.save(produit).getId();

        return idProduit;
    }

    public List<Produit> getAllProduit()
    {
        return produitRepository.findAll();
    }

    public Produit getProduitById(int id)
    {
        return produitRepository.findById(id).get();
    }

    public void insertPrixVenteProduit(int idProduit, double prixVente, Date date)
    {
        PrixVenteProduit prixVenteProduit = new PrixVenteProduit();
        prixVenteProduit.setIdProduit(idProduit);
        prixVenteProduit.setPrixVente(prixVente);
        prixVenteProduit.setDate(date);

        prixVenteProduitRepository.save(prixVenteProduit);
    }

    public double prixRevient(int idProduit)
    {
        double prixPersonnel = vPrixPersonnelProductionRepository.findByIdProduit(idProduit).getPrix();
        double prixMatiere = vPrixProduitService.getPrixProduitByIdProduit(idProduit).getPrix();

        double total = prixPersonnel + prixMatiere;
        
        return total;
    }
    
}
