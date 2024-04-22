package com.projet.poketra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.projet.poketra.models.Produit;
import com.projet.poketra.models.VDetailsLook;
import com.projet.poketra.services.DetailsProduitService;
import com.projet.poketra.services.VDetailsLookService;
import com.projet.poketra.utility.Utility;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DetailsProduitController {
    
    @Autowired
    private DetailsProduitService detailsProduitService;

    @Autowired
    private VDetailsLookService vDetailsLookService;

    @GetMapping("/pageInsertioneDetailsProduit")
    public String pageInsertionDetailsProduit(HttpServletRequest request, Model model)
    {
        try {
            
            int idLook = Integer.parseInt(request.getParameter("idLook"));
            int idType = Integer.parseInt(request.getParameter("idType"));
            int idTaille = Integer.parseInt(request.getParameter("idTaille"));


            model.addAttribute("matieres", vDetailsLookService.getDetailsLookByIdLookOrderByNomMatiere(idLook));
            
            model.addAttribute("idLook", idLook);
            model.addAttribute("idType", idType);
            model.addAttribute("idTaille", idTaille);


            return "insertionDetailsProduit";
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

    @PostMapping("/insertDetailsProduit")
    public String insertDetailsProduit(HttpServletRequest request)
    {
        try {
            int idLook = Integer.parseInt(request.getParameter("idLook"));
            int idType = Integer.parseInt(request.getParameter("idType"));
            int idTaille = Integer.parseInt(request.getParameter("idTaille"));

            Produit produit = new Produit();
            produit.setIdLook(idLook);
            produit.setIdType(idType);
            produit.setIdTaille(idTaille);

            List<VDetailsLook> vDetailsLooks = vDetailsLookService.getDetailsLookByIdLookOrderByNomMatiere(idLook);
            double[] quantite = new double[vDetailsLooks.size()];

            for(int i = 0; i < vDetailsLooks.size(); i++)
            {
                double q = Double.parseDouble(request.getParameter(vDetailsLooks.get(i).getNomMatiere()));
                quantite[i] = q;
            }
            
            detailsProduitService.insertDetailsProduit(produit, quantite, vDetailsLooks);

            return "redirect:/pageInsertionProduit";
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
