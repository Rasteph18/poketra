package com.projet.poketra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.projet.poketra.models.Look;
import com.projet.poketra.services.LookService;

@Controller
public class LookController {
    
    @Autowired
    private LookService lookService;

    @GetMapping("/")
    public String index()
    {
        return "index";
    }

    @GetMapping("/pageInsertionLook")
    public String pageInsertionLook(Model model)
    {
        Look look = new Look();
        model.addAttribute("look", look);
        return "insertionLook";
    }

    @GetMapping("/insertLook")
    public String insertLook(@ModelAttribute Look look)
    {
        lookService.insertLook(look);
        return "redirect:/pageInsertionLook";
    }
}
