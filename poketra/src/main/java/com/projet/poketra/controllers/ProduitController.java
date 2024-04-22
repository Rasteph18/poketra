package com.projet.poketra.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projet.poketra.models.DetailsProduction;
import com.projet.poketra.models.PrixVenteProduit;
import com.projet.poketra.models.Produit;
import com.projet.poketra.models.VDetailsProduit;
import com.projet.poketra.services.DetailsProductionService;
import com.projet.poketra.services.FabricationService;
import com.projet.poketra.services.LookService;
import com.projet.poketra.services.PersonnelService;
import com.projet.poketra.services.PrixVenteProduitService;
import com.projet.poketra.services.ProduitService;
import com.projet.poketra.services.TailleService;
import com.projet.poketra.services.TypeService;
import com.projet.poketra.services.VBeneficeProduitService;
import com.projet.poketra.services.VDetailsProduitService;
import com.projet.poketra.services.VPrixProduitService;
import com.projet.poketra.services.VResteProduitService;
import com.projet.poketra.services.VStatistiqueNbVenteService;
import com.projet.poketra.utility.Utility;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;  

@Controller
public class ProduitController {

    @Autowired
    private LookService lookService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TailleService tailleService;

    @Autowired
    private VPrixProduitService vPrixProduitService;

    @Autowired
    private FabricationService fabricationService;

    @Autowired
    private VDetailsProduitService VDetailsProduitService;

    @Autowired
    private PersonnelService personnelService;

    @Autowired
    private ProduitService produitService;

    @Autowired
    private DetailsProductionService detailsProductionService;

    @Autowired
    private PrixVenteProduitService prixVenteProduitService;

    @Autowired
    private VStatistiqueNbVenteService vStatistiqueNbVenteService;

    @Autowired
    private VBeneficeProduitService vBeneficeProduitService;

    @Autowired
    private VResteProduitService vResteProduitService;

    @GetMapping("/pageInsertionProduit")
    public String pageInsertionProduit(Model model)
    {

        try {
            model.addAttribute("allLook", lookService.getAllLook());
            model.addAttribute("allType", typeService.getAllType());
            model.addAttribute("allTaille", tailleService.getAllTaille());

            return "insertionProduit";
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

    @GetMapping("/insertProduit")
    public String insertProduit(@ModelAttribute Produit produit, Model model)
    {
        try {
            return "redirect:/pageInsertioneDetailsProduit?idLook=" + produit.getIdLook() + "&idType=" + produit.getIdType() + "&idTaille=" + produit.getIdTaille();
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

    @GetMapping("/listProduitByPrix")
    public String page(@RequestParam(required = false, name = "prixMin") String min, @RequestParam(required = false, name = "prixMax") String max, Model model)
    {
        if(min != null && max != null) {
            model.addAttribute("min", min);
            model.addAttribute("max", max);
            model.addAttribute("listPrixProduit", vPrixProduitService.getListPrixProduit(Double.valueOf(min), Double.valueOf(max)));
        } else if(min == null || max == null) {
            model.addAttribute("min", 0);
            model.addAttribute("max", 0);
            model.addAttribute("listPrixProduit", List.of());
        }
        
        return "listProduitByPrix";
    }

    @GetMapping("/prixProduit")
    public String pageValeurPrixProduit(HttpServletRequest request, Model model)
    {
        String min = (String)request.getParameter("prixMin");
        String max = (String)request.getParameter("prixMax");

        

        model.addAttribute("listPrixProduit", vPrixProduitService.getListPrixProduit(Double.valueOf(min), Double.valueOf(max)));
        return "listPrixProduit";
    }

    @GetMapping("/pagefabrication")
    public String pageFabrication(HttpServletRequest request, Model model)
    {
        model.addAttribute("allProduit", VDetailsProduitService.getDetailsProduit());

        return "insertionFabrication";
    }

    @PostMapping("/insertFabrication")
    public String insertFabrication(HttpServletRequest request, Model model)
    {
        String idProduit = (String)request.getParameter("idProduit");
        String quantite = (String)request.getParameter("quantite");
        String dateJour = (String)request.getParameter("date");

        try {
            fabricationService.insertFabrication(idProduit, quantite, dateJour);
            
            return "redirect:/pagefabrication";
        } catch (Exception e) {
            Map<String, Double> verifQuantite = fabricationService.verifQuantite(Integer.parseInt(idProduit), Double.valueOf(quantite), dateJour, false);
            
            model.addAttribute("quantiteInsuffisant", verifQuantite);
            return "quantiteInsuffisant";
        }
    }


    @GetMapping("/listAllProduit")
    public String getAllProduit(Model model)
    {
        model.addAttribute("listProduit", VDetailsProduitService.getDetailsProduit());
        return "listAllProduit";
    }

    @GetMapping("/pageDetailsProduction")
    public String redirectPageInsertDetailsProduction(@RequestParam("idProduit") int idProduit, HttpSession session)
    {
        session.setAttribute("idProduit", idProduit);
        return "redirect:/pageInsertDetailsProduction";
    }

    @GetMapping("/pageInsertDetailsProduction")
    public String pageInsertDetailsProduction(Model model, HttpSession session)
    {
        List<DetailsProduction> listDetailsProduction = new ArrayList<>();
        if(session.getAttribute("listDetailsProduction") != null) {
            listDetailsProduction = (List<DetailsProduction>)session.getAttribute("listDetailsProduction");
        }


        model.addAttribute("allPersonnel", personnelService.getAllPersonnel());
        model.addAttribute("listDetailsPorduction", listDetailsProduction);

        return "insertionDetailsProduction";
    }

    @PostMapping("/controlDetailsProduction")
    public String controlDetailsProduction(HttpSession session, @ModelAttribute DetailsProduction detailsProduction)
    {
        int idProduit = (Integer)session.getAttribute("idProduit");
        if(session.getAttribute("listDetailsProduction") != null) {
            List<DetailsProduction> listDetailsProduction = (List<DetailsProduction>)session.getAttribute("listDetailsProduction");
            DetailsProduction detailsProductTemp = new DetailsProduction();
            detailsProductTemp.setIdProduit(idProduit);
            detailsProductTemp.setPersonnel(personnelService.getById(detailsProduction.getIdPersonnel()));
            detailsProductTemp.setNbPersonnel(detailsProduction.getNbPersonnel());
            detailsProductTemp.setHeureTravail(detailsProduction.getHeureTravail());
            
            listDetailsProduction.add(detailsProductTemp);

            session.setAttribute("listDetailsProduction", listDetailsProduction);
        } else {
            List<DetailsProduction> listDetailsProduction = new ArrayList<>();
            DetailsProduction detailsProductTemp = new DetailsProduction();
            detailsProductTemp.setIdProduit(idProduit);
            detailsProductTemp.setPersonnel(personnelService.getById(detailsProduction.getIdPersonnel()));
            detailsProductTemp.setNbPersonnel(detailsProduction.getNbPersonnel());
            detailsProductTemp.setHeureTravail(detailsProduction.getHeureTravail());

            listDetailsProduction.add(detailsProductTemp);

            session.setAttribute("listDetailsProduction", listDetailsProduction);
        }


        return "redirect:/pageInsertDetailsProduction";
    }

    @GetMapping("/insertDetailsProduction")
    public String insertDetailsProduction(HttpSession session)
    {
        try {
            int idProduit = (Integer)session.getAttribute("idProduit");
            List<DetailsProduction> listDetailsProduction = (List<DetailsProduction>)session.getAttribute("listDetailsProduction");

            detailsProductionService.controllInsertionDetailsProduction(idProduit, listDetailsProduction);

            return "redirect:/listAllProduit";

        } catch (Exception e) {
            try {
                Utility utility = new Utility();

                String message = utility.encodedMessage(e.getMessage());
                return "redirect:/error?message=" + message;
            } catch (Exception ex) {
                return "redirect:/error?message=An encoding message";
            }
        } finally {
            session.setAttribute("idProduit", 0);
            session.setAttribute("listDetailsProduction", new ArrayList<DetailsProduction>());
        }
        
    }

    @GetMapping("/pageInsertPrixVenteProduit")
    public String pageInsertPrixVenteProduit(Model model)
    {
        model.addAttribute("listProduit", VDetailsProduitService.getDetailsProduit());
        return "insertionPrixVenteProduit";
    }

    @PostMapping("/insertPrixVenteProduit")
    public String insertPrixVenteProduit(@ModelAttribute PrixVenteProduit prixVenteProduit)
    {
        try {
            prixVenteProduitService.insertPrixVenteProduit(prixVenteProduit);
            return "redirect:/pageInsertPrixVenteProduit";
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

    @GetMapping("/beneficeEntreDeuxPrix")
    public String pageBeneficeEntreDeuxPrix(@RequestParam(required = false) String min, 
                                            @RequestParam(required = false) String max,
                                            Model model)
    {
        if(min == null && max == null) {
            model.addAttribute("min",0);
            model.addAttribute("max", 0);
           model.addAttribute("listBenefice", List.of());
        } else if(min != null && max != null) {
            model.addAttribute("min",min);
            model.addAttribute("max", max);
            model.addAttribute("listBenefice", vBeneficeProduitService.getAllBeneficeBetween(Double.valueOf(min), Double.valueOf(max)));
        }

        return "beneficeEntreDeuxPrix";
    }


    @GetMapping("/pageStatistiqueVente")
    public String pageStatistiqueVente(@RequestParam(required = false) String idProduit, Model model)
    {
        List<VDetailsProduit> listProduit = VDetailsProduitService.getDetailsProduit();

        if(idProduit == null || idProduit.equals("0")) {
            model.addAttribute("statistique", vStatistiqueNbVenteService.getStatOfAllVente());
            model.addAttribute("descriProduit", "Tout les produits");
        } else if(idProduit != null) {
            model.addAttribute("statistique", vStatistiqueNbVenteService.getStatByIdProduit(idProduit));
            VDetailsProduit produit = VDetailsProduitService.getDetailsProduitByIdProduit(idProduit);
            String nomProduit = produit.getType() + " " + produit.getLook() + " " + produit.getTaille();
            model.addAttribute("descriProduit", nomProduit);
        }

        model.addAttribute("listProduit", listProduit);
        return "statistiqueVente";
    }

    @GetMapping("/getResteStockProduit")
    public String getResteStockProduit(Model model)
    {
        model.addAttribute("listProduit", vResteProduitService.getAllResteProduit());
        return "resteStockProduit";
    }

}
