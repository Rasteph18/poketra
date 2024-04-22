package com.projet.poketra.services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.poketra.models.PrixMatiere;
import com.projet.poketra.models.StockMatiere;
import com.projet.poketra.repository.StockMatiereRepository;

@Service
public class StockMatiereService {
    
    @Autowired
    private StockMatiereRepository stockMatiereRepository;

    @Autowired
    private PrixMatiereService prixMatiereService;

    @Transactional
    public void insertStockMatiere(String idMatiere, String quantite, String dateJour, String prix) throws Exception
    {
        StockMatiere stockMatiere = new StockMatiere();

        int matiere = Integer.parseInt(idMatiere);
        double Dquantite = Double.valueOf(quantite);
        
        double dPrix = Double.valueOf(prix);

        PrixMatiere prixMatiere = new PrixMatiere();
        prixMatiere.setIdMatiere(matiere);
        prixMatiere.setPrix(dPrix);
        prixMatiere.setDateJour(dateJour);

        prixMatiereService.insertPrixMatiere(prixMatiere);

        stockMatiere.setIdMatiere(matiere);
        stockMatiere.setQuantiteEntre(Dquantite);
        stockMatiere.setQuantiteSorti(0);
        stockMatiere.setDateJour(Date.valueOf(dateJour));

        stockMatiereRepository.save(stockMatiere);

    }

    public void manalaEnStock(String idMatiere, String quantiteAEnleve, String dateJour)
    {
        StockMatiere stockMatiere = new StockMatiere();
        int matiere = Integer.parseInt(idMatiere);
        double DquantiteAEnleve = Double.valueOf(quantiteAEnleve);

        stockMatiere.setIdMatiere(matiere);
        stockMatiere.setQuantiteEntre(0);
        stockMatiere.setQuantiteSorti(DquantiteAEnleve);
        stockMatiere.setDateJour(Date.valueOf(dateJour));

        stockMatiereRepository.save(stockMatiere);
    }


    public double getQuantiteRestantByMatiere(int idMatiere)
    {
        return stockMatiereRepository.resteEnStock(idMatiere);
    }

}
