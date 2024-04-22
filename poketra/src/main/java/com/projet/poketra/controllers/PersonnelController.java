package com.projet.poketra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projet.poketra.models.DureTravailPersonnel;
import com.projet.poketra.models.NbPersonnelTaille;
import com.projet.poketra.models.Personnel;
import com.projet.poketra.models.SalairePersonnel;
import com.projet.poketra.models.Taille;
import com.projet.poketra.services.DureTravailPersonnelService;
import com.projet.poketra.services.LookService;
import com.projet.poketra.services.NbPersonnelTailleService;
import com.projet.poketra.services.PersonnelService;
import com.projet.poketra.services.SalairePersonnelService;
import com.projet.poketra.services.TailleService;


@Controller
public class PersonnelController {
    
    @Autowired
    private PersonnelService personnelService;

    @Autowired
    private SalairePersonnelService salairePersonnelService;

    @Autowired
    private TailleService tailleService;

    @Autowired
    private NbPersonnelTailleService nbPersonnelTailleService;

    @Autowired
    private LookService lookService;

    @Autowired
    private DureTravailPersonnelService dureTravailPersonnelService;

    @GetMapping("/pageInsertPersonnel")
    public String pageInsertionPersonnel()
    {
        return "insertionPersonnel";
    }

    @PostMapping("/insertPersonnel")
    public String insertionPersonnel(@ModelAttribute Personnel personnel)
    {
        personnelService.insertPersonnel(personnel);
        return "redirect:/pageInsertPersonnel";
    }

    @GetMapping("/pageInsertSalairePersonnel")
    public String pageInsertionSalairePersonnel(Model model)
    {
        model.addAttribute("allPersonnel", personnelService.getAllPersonnel());
        return "insertionSalairePersonnel";
    }

    @PostMapping("/insertSalairePersonnel")
    public String insertSalairePersonnel(@ModelAttribute SalairePersonnel salairePersonnel)
    {
        salairePersonnelService.insertSalairePersonnel(salairePersonnel);
        return "redirect:/pageInsertSalairePersonnel";
    }


    @GetMapping("/pageNbPersonnelByTaille")
    public String pageNbPersonnelByTaille(Model model)
    {
        Taille taillePlusPetit = tailleService.tailleLePlusPetit();

        model.addAttribute("taillePlusPetit", taillePlusPetit);

        return "insertionNbPersonnelByTaille";
    }

    @PostMapping("/insertNbPersonnelByTaille")
    public String insertNbPersonnelByTaille(@ModelAttribute NbPersonnelTaille nbPersonnelTaille)
    {
        nbPersonnelTailleService.insertNbPersonneTaille(nbPersonnelTaille);

        return "redirect:/pageNbPersonnelByTaille";
    }

    @GetMapping("/pageDureTravailPersonnel")
    public String pageDureTravailPersonnel(Model model)
    {
        model.addAttribute("listLook", lookService.getAllLook());

        return "insertionDureTravail";
    }

    @PostMapping("/insertDureTravailPersonnel")
    public String insertDureTravailPersonnel(@ModelAttribute DureTravailPersonnel dureTravailPersonnel)
    {
        dureTravailPersonnelService.insertDureTravailPersonnel(dureTravailPersonnel);
        return "redirect:/pageDureTravailPersonnel";
    }

}
