package com.projet.poketra.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.poketra.models.DetailsProduit;
import com.projet.poketra.models.Fabrication;
import com.projet.poketra.models.Matiere;
import com.projet.poketra.repository.FabricationRepository;

@Service
public class FabricationService {
    
    @Autowired
    private FabricationRepository fabricationRepository;

    @Autowired
    private DetailsProduitService detailsProduitService;

    @Autowired
    private StockMatiereService stockMatiereService;

    @Autowired
    private MatiereService matiereService;


    @Transactional
    public void insertFabrication(String idProduit, String quantite, String dateJour) throws Exception
    {
        int produit = Integer.parseInt(idProduit);
        double Dquantite = Double.valueOf(quantite);
        Date date = Date.valueOf(dateJour);

        Map<String, Double> verifQuantite = verifQuantite(produit, Dquantite, dateJour, true);

        if(verifQuantite.size() > 0) {
            throw new Exception("Quantite insuffisant");
        }

        Fabrication fabrication = new Fabrication();

        fabrication.setIdProduit(produit);
        fabrication.setQuantite(Dquantite);
        fabrication.setDateJour(date);

        fabricationRepository.save(fabrication);
    }   

    @Transactional
    public void insertSortiFabrication(int idProduit, double quantite) throws Exception
    {
        LocalDate currentDate = LocalDate.now();
        Date date = Date.valueOf(currentDate);

        // Map<String, Double> verifQuantite = verifQuantite(produit, Dquantite, dateJour, true);

        // if(verifQuantite.size() > 0) {
        //     throw new Exception("Quantite insuffisant");
        // }

        Fabrication fabrication = new Fabrication();

        fabrication.setIdProduit(idProduit);
        fabrication.setQuantite(quantite);
        fabrication.setDateJour(date);

        fabricationRepository.save(fabrication);
    }   

    public Fabrication getResteProduitByIdProduit(int idProduit)
    {
        return fabricationRepository.getResteProduitByIdProduit(idProduit);
    }

    public Map<String, Double> verifQuantite(int idProduit, double quantiteBesoin, String dateJour, boolean isManala)
    {
        List<DetailsProduit> listDetailsProduit = detailsProduitService.getDetailsProduitByIdProduit(idProduit);
        Map<String, Double> detailsInsuffisant = new HashMap<>();


        for(int i = 0; i < listDetailsProduit.size(); i++)
        {
            DetailsProduit detailsProduit = listDetailsProduit.get(i);
            double quantiteIlainaByMatiere = detailsProduit.getQuantite() * quantiteBesoin;
            double quantiteRestantByMatiere = stockMatiereService.getQuantiteRestantByMatiere(detailsProduit.getIdMatiere());
            Matiere matiere = matiereService.getMatiereById(detailsProduit.getIdMatiere());

            if(quantiteIlainaByMatiere > quantiteRestantByMatiere) {
                double quantiteInsuffisant = quantiteIlainaByMatiere - quantiteRestantByMatiere;
                detailsInsuffisant.put(matiere.getNom(), quantiteInsuffisant);
            } else {
                if(isManala == true) {
                    String idMatiere = String.valueOf(matiere.getId());
                    String quantiteAEnleve = String.valueOf(quantiteIlainaByMatiere);
                    stockMatiereService.manalaEnStock(idMatiere, quantiteAEnleve, dateJour);
                }
            }
        }

        return detailsInsuffisant;
    }

}
