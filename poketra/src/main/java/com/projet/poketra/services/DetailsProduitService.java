package com.projet.poketra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.poketra.models.DetailsProduit;
import com.projet.poketra.models.Produit;
import com.projet.poketra.models.VDetailsLook;
import com.projet.poketra.repository.DetailsProduitRepository;
import com.projet.poketra.repository.ProduitRepository;

@Service
public class DetailsProduitService {
    
    @Autowired
    private DetailsProduitRepository detailsProduitRepository;

    @Autowired
    private ProduitRepository produitRepository;

    @Transactional
    public void insertDetailsProduit(Produit produit, double[] quantite, List<VDetailsLook> vDetailsLooks) throws Exception
    {
        int saveProduit = produitRepository.save(produit).getId();
        DetailsProduit detailsProduit = null;

        for(int i = 0; i < vDetailsLooks.size(); i++)
        {
            if(quantite[i] == 0)
            {
                continue;
            }
            detailsProduit = new DetailsProduit();

            detailsProduit.setIdProduit(saveProduit);
            detailsProduit.setIdMatiere(vDetailsLooks.get(i).getIdMatiere());
            detailsProduit.setQuantite(quantite[i]);

            detailsProduitRepository.save(detailsProduit);
        }
    }

    public List<DetailsProduit> getDetailsProduitByIdProduit(int idMatiere)
    {
        return detailsProduitRepository.getDetailsProduitByIdProduit(idMatiere);
    }
}
