package com.projet.poketra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projet.poketra.models.VDetailsProduit;
import com.projet.poketra.models.Vente;
import com.projet.poketra.services.ClientService;
import com.projet.poketra.services.VDetailsProduitService;
import com.projet.poketra.services.VenteService;
import com.projet.poketra.utility.Utility;

import org.springframework.stereotype.Controller;

@Controller
public class VenteController {
    
    @Autowired
    private VenteService venteService;

    @Autowired
    private VDetailsProduitService vDetailsProduitService;

    @Autowired
    private ClientService clientService;


    @GetMapping("/pageInsertVente")
    public String pageInsertVente(Model model)
    {
        model.addAttribute("allProduit", vDetailsProduitService.getDetailsProduit());
        model.addAttribute("allClient", clientService.getAllClient());


        return "insertionVente";
    }

    @PostMapping("/insertVente")
    public String insertVente(@ModelAttribute Vente vente)
    {
        try {
            venteService.insertVente(vente);

            return "redirect:/pageInsertVente";
        } catch (Exception e) {
            try {
                Utility utility = new Utility();

                String message = utility.encodedMessage(e.getMessage());
                return "redirect:/error?message=" + message;
            } catch (Exception ex) {
                return "redirect:/error?message=An encoding message";
            }
        }
        
    }
}
