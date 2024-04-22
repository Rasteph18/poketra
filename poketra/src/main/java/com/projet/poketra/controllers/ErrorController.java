package com.projet.poketra.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ErrorController {
    
    @GetMapping("/error")
    public String pageError(@RequestParam String message, Model model) throws Exception
    {
        System.out.println("blabla");
        System.out.println("ito le erreur" + message);
        model.addAttribute("message", message);

        return "error";
    }
}
