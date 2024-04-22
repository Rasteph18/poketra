package com.projet.poketra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.projet.poketra.models.Employe;
import com.projet.poketra.services.EmployeService;
import com.projet.poketra.services.VDetailsEmployeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeController {
    
    @Autowired
    private EmployeService employeService;

    @Autowired
    private VDetailsEmployeService vDetailsEmployeService;

    @GetMapping("/pageInsertionEmploye")
    public String pageInsertionEmploye()
    {
        return "insertionEmploye";
    }

    @GetMapping("/redirectEmbauche")
    public String redirectEmbauche(@ModelAttribute Employe employe, HttpSession session)
    {
        session.setAttribute("employe", employe);

        return "redirect:/pageInsertEmbauche";
    }

    @GetMapping("/detailsEmploye")
    public String detailsEmploye(Model model)
    {
        model.addAttribute("detailsEmploye", vDetailsEmployeService.getAllDetailsEmploye());
        return "detailsEmploye";
    }


}
