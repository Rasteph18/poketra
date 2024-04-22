package com.projet.poketra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projet.poketra.models.NbPersonnelTaille;
import com.projet.poketra.models.Taille;
import com.projet.poketra.services.TailleService;

@Controller
public class TailleController {
    
    @Autowired
    private TailleService tailleService;

    @GetMapping("/pageInsertionTaille")
    public String pageInsertionTaille(Model model)
    {
        Taille taille = new Taille();
        model.addAttribute("taille", taille);
        return "insertionTaille";
    }

    @PostMapping("/insertTaille")
    public String insertTaille(@ModelAttribute Taille taille, Model model)
    {
        try {
            tailleService.insertTaille(taille);
            return "redirect:/pageInsertionTaille";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "redirect:/error";
        }
        
    }

    @GetMapping("/pageInsertNbPersonnelTaille")
    public String pageInsertNbPersonnelTaille(Model model)
    {
        try {
            model.addAttribute("allTaille", tailleService.getAllTaille());
            return "insertionNbPersonnelTaille";
        } catch (Exception e) {
            return "";
        }
        
    }


    @PostMapping("/insertNbPersonnelTaille")
    public String insertNbPersonnelTaille(@ModelAttribute NbPersonnelTaille nbPersonnelTaille)
    {
        tailleService.insertNbPersonneTaille(nbPersonnelTaille);
        return "redirect:/pageInsertNbPersonnelTaille";
    }
}
