package com.projet.poketra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.projet.poketra.services.DetailsLookService;
import com.projet.poketra.services.LookService;
import com.projet.poketra.services.MatiereService;
import com.projet.poketra.utility.Utility;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DetailsLookController {
    
    @Autowired
    private DetailsLookService detailsLookService;

    @Autowired
    private LookService lookService;

    @Autowired
    private MatiereService matiereService;

    @GetMapping("/pageInsertionDetailsLook")
    public String pageInsertionDetailsLook(Model model)
    {
        model.addAttribute("allLook", lookService.getAllLook());
        model.addAttribute("allMatiere", matiereService.getAllMatiere());
        return "insertionDetailsLook";
    }

    @PostMapping("/insertDetailsLook")
    public String insertDetailsLook(HttpServletRequest request)
    {
        try {
            String idLook = request.getParameter("idLook");
            String[] idMatiere = request.getParameterValues("idMatiere");

            detailsLookService.insertDetailsLook(idLook, idMatiere);

            return "redirect:/pageInsertionDetailsLook";
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
