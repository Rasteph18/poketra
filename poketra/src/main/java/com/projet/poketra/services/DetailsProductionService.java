package com.projet.poketra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.poketra.models.DetailsProduction;
import com.projet.poketra.models.DureTravailPersonnel;
import com.projet.poketra.models.NbPersonnelTaille;
import com.projet.poketra.models.Produit;
import com.projet.poketra.models.Taille;
import com.projet.poketra.repository.DetailsProductionRepository;

@Service
public class DetailsProductionService {
    
    @Autowired
    private DetailsProductionRepository detailsProductionRepository;

    @Autowired
    private DureTravailPersonnelService dureTravailPersonnelService;

    @Autowired
    private ProduitService produitService;

    @Autowired
    private TailleService tailleService;

    @Autowired
    private NbPersonnelTailleService nbPersonnelTailleService;

    public void insertDetailsProduction(DetailsProduction detailsProduction)
    {
        detailsProductionRepository.save(detailsProduction);
    }

    @Transactional
    public void controllInsertionDetailsProduction(int idProduit, List<DetailsProduction> listDetailsPorduction) throws Exception
    {

        Produit produit = produitService.getProduitById(idProduit);

        //check total heure de travail
        DureTravailPersonnel dureTravailPersonnel = dureTravailPersonnelService.getByIdlook(produit.getIdLook());
        double dureTotal = dureTravailPersonnel.getDure();
        double dureEntre = 0;

        for(int i = 0; i < listDetailsPorduction.size(); i++)
        {
            dureEntre = dureEntre + listDetailsPorduction.get(i).getHeureTravail();
        }

        if(dureEntre != dureTotal)
        {
            throw new Exception("La totale du durée de travail entré ne correspond pas au durée de travail attendu");
        }


        //check total nombre personnel
        NbPersonnelTaille nbPersonnelTaille = nbPersonnelTailleService.getLastNbPersonnelTaille();
        Taille petiteTaille = tailleService.getTailleById(nbPersonnelTaille.getIdTaille());
        Taille tailleTraiter = tailleService.getTailleById(produit.getIdTaille());

        int diff = Math.abs((petiteTaille.getCoefficient() - tailleTraiter.getCoefficient())/10);
        if(diff == 0) {
            diff = 1;
        }

        int nbPersonnelTotal = diff * nbPersonnelTaille.getNbPersonnel();
        int nbPesonnelEntre = 0;

        for(int i = 0; i < listDetailsPorduction.size(); i++)
        {
            nbPesonnelEntre = nbPesonnelEntre + listDetailsPorduction.get(i).getNbPersonnel();
        }

        if(nbPesonnelEntre != nbPersonnelTotal) {
            throw new Exception("La totale de nombre personnel entré ne correspond pas au nombre personnel attendu");
        }

        // insert details production
        for(int i = 0; i < listDetailsPorduction.size(); i++)
        {
            DetailsProduction detailsProductionTemp = new DetailsProduction();
            detailsProductionTemp.setIdProduit(idProduit);
            detailsProductionTemp.setIdPersonnel(listDetailsPorduction.get(i).getPersonnel().getId());
            detailsProductionTemp.setNbPersonnel(listDetailsPorduction.get(i).getNbPersonnel());
            detailsProductionTemp.setHeureTravail(listDetailsPorduction.get(i).getHeureTravail());

            insertDetailsProduction(detailsProductionTemp);
        }

    }
}
