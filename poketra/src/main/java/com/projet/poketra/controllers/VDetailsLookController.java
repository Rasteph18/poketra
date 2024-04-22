package com.projet.poketra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projet.poketra.services.LookService;
import com.projet.poketra.services.VDetailsLookService;

@Controller
public class VDetailsLookController {
    
    @Autowired
    private VDetailsLookService vDetailsLookService;

    @Autowired
    private LookService lookService;


    @GetMapping("/getMatiereByLook")
    public ModelAndView selectMatiereByIdLook(@RequestParam(required = false) String idLook)
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("detailLook");
        mav.addObject("allLook", lookService.getAllLook());

        if(idLook != null)
        {
            mav.addObject("allMatiere", vDetailsLookService.getDetailsLookByIdLookOrderByNomMatiere(Integer.parseInt(idLook)));
        } else if(idLook == null)
        {
            mav.addObject("allMatiere", List.of());
        }

        return mav;
    }
}
