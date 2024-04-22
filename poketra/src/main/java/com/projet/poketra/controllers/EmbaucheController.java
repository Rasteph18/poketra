package com.projet.poketra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projet.poketra.models.Embauche;
import com.projet.poketra.models.Employe;
import com.projet.poketra.services.EmbaucheService;
import com.projet.poketra.services.PersonnelService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmbaucheController {
    
    @Autowired
    private EmbaucheService embaucheService;

    @Autowired
    private PersonnelService personnelService;

    @GetMapping("/pageInsertEmbauche")
    public String pageInsertEmbauche(Model model)
    {
        model.addAttribute("allPersonnel", personnelService.getAllPersonnel());
        return "insertionEmbauche";
    }

    @PostMapping("/insertEmbauche")
    public String insertEmbauche(HttpSession session, @ModelAttribute Embauche embauche)
    {
        Employe employe = (Employe)session.getAttribute("employe");

        embaucheService.insertEmbauche(employe, embauche);

        return "redirect:/pageInsertEmbauche";
    }

}
