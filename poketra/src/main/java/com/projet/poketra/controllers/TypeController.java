package com.projet.poketra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projet.poketra.models.Type;
import com.projet.poketra.services.TypeService;

@Controller
public class TypeController {
    
    @Autowired
    private TypeService typeService; 

    @GetMapping("/pageInsertionType")
    public String pageInsertionType(Model model)
    {
        Type type = new Type();
        model.addAttribute("type", type);
        return "insertionType";
    }

    @PostMapping("/insertType")
    public String insertType(@ModelAttribute Type type)
    {
        try {
            typeService.insertType(type);

            return "redirect:/pageInsertionType";
        } catch (Exception e) {
            return "redirect:/error?message=" + e.getMessage();
        }
        
    }

}
