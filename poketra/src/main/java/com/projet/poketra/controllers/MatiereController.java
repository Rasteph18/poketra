package com.projet.poketra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projet.poketra.models.Matiere;
import com.projet.poketra.models.PrixMatiere;
import com.projet.poketra.services.MatiereService;
import com.projet.poketra.services.PrixMatiereService;
import com.projet.poketra.services.StockMatiereService;
import com.projet.poketra.services.VDetailsStockMatiereService;
import com.projet.poketra.services.VLookTailleTypeService;
import com.projet.poketra.utility.Utility;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MatiereController {
    
    @Autowired
    private MatiereService matiereService;

    @Autowired
    private PrixMatiereService prixMatiereService;

    @Autowired
    private VLookTailleTypeService vLookTailleTypeService;

    @Autowired
    private StockMatiereService stockMatiereService;

    @Autowired
    private VDetailsStockMatiereService vDetailsStockMatiereService;

    @GetMapping("/pageInsertionMatiere")
    public String pageInsertionMatiere()
    {
        return "insertionMatiere";
    }

    @PostMapping("/insertMatiere")
    public String insertMatiere(@RequestParam String nom)
    {
        Matiere matiere = new Matiere();
        matiere.setNom(nom);
        matiereService.insertMatiere(matiere);
        return "redirect:/pageInsertionMatiere";
    }

    @GetMapping("/aboutMatiere")
    public String pageAProposMatiere(@RequestParam(required = false) String idMatiere, Model model)
    {
        try {
            model.addAttribute("listMatiere", matiereService.getAllMatiere());

            if(idMatiere != null)
            {
                model.addAttribute("aboutMatiere", vLookTailleTypeService.findByIdMatiere(idMatiere));
            } else if(idMatiere == null)
            {
                model.addAttribute("aboutMatiere", List.of());
            }

            return "aProposMatiere";
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

    @GetMapping("/pageInsertionPrixMatiere")
    public String pageInsertPrixMatiere(Model model)
    {
        model.addAttribute("listMatiere", matiereService.getAllMatiere());
        return "insertionPrixMatiere";
    }

    @PostMapping("/insertPrixMatiere")
    public String insertPrixMatiere(HttpServletRequest request)
    {
        try {
            String idMatiere = (String)request.getParameter("idMatiere");
            String prix = (String)request.getParameter("prix");
            String date = (String)request.getParameter("date");

            PrixMatiere prixMatiere = new PrixMatiere();
            prixMatiere.setIdMatiere(Integer.parseInt(idMatiere));
            prixMatiere.setPrix(Double.parseDouble(prix));
            prixMatiere.setDateJour(date);

            prixMatiereService.insertPrixMatiere(prixMatiere);

            return "redirect:/pageInsertionPrixMatiere";
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

    @GetMapping("/pageInsertStockMatiere")
    public String pageInsertStockMatiere(Model model)
    {
        model.addAttribute("listMatiere", matiereService.getAllMatiere());
        return "insertionStockMatiere";
    }

    @PostMapping("/insertStockMatiere")
    public String insertStockMatiere(HttpServletRequest request)
    {

        try {
            String idMatiere = (String)request.getParameter("idMatiere");
            String quantite = (String)request.getParameter("quantite");
            String dateJour = (String)request.getParameter("date");
            String prix = (String)request.getParameter("prix");

            stockMatiereService.insertStockMatiere(idMatiere, quantite, dateJour, prix);
            return "redirect:/pageInsertStockMatiere";
        } catch (Exception e) {
            return "";
        }
        
    }

    @GetMapping("/detailsStockMatiere")
    public String detailsStockMatiere(Model model)
    {
        model.addAttribute("detailsStockMatiere", vDetailsStockMatiereService.getDetailsStockMatiere());
        return "detailsStockMatiere";
    }
}
