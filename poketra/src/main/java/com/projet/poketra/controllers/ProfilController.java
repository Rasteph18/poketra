package com.projet.poketra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projet.poketra.models.Profil;
import com.projet.poketra.services.ProfilService;
import com.projet.poketra.services.VProfilEmployeService;

@Controller
public class ProfilController {
    
    @Autowired
    private ProfilService profilService;

    @Autowired
    private VProfilEmployeService vProfilEmployeService;

    @GetMapping("/pageInsertProfil")
    public String pageInsertProfil()
    {
        return "insertionProfil";
    }

    @PostMapping("/insertProfil")
    public String insertProfil(@ModelAttribute Profil profil)
    {
        profilService.insertProfil(profil);

        return "redirect:/pageInsertProfil";
    }

    @GetMapping("/getAllProfilEmploye")
    public String getAllProfilEmploye(Model model)
    {
        model.addAttribute("profilEmploye", vProfilEmployeService.getAllProfilEmploye());
        return "listProfilAllEmploye";
    }
}
