package com.projet.poketra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projet.poketra.models.Client;
import com.projet.poketra.services.ClientService;
import com.projet.poketra.services.GenreService;

@Controller
public class ClientController {
    
    @Autowired
    private ClientService clientService;

    @Autowired
    private GenreService genreService;

    @GetMapping("/pageInsertClient")
    public String pageInsertClient(Model model)
    {
        model.addAttribute("allGenre", genreService.getAllGenre());
        return "insertionClient";
    }

    @PostMapping("/insertClient")
    public String insertClient(@ModelAttribute Client client)
    {
        clientService.insertClient(client);

        return "redirect:/pageInsertClient";
    }
}
