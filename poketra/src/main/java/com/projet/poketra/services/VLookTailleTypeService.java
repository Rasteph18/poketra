package com.projet.poketra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.poketra.models.VLookTailleType;
import com.projet.poketra.repository.VLookTailleTypeRepository;

@Service
public class VLookTailleTypeService {
    
    @Autowired
    private VLookTailleTypeRepository vLookTailleTypeRepository;

    public List<VLookTailleType> findByIdMatiere(String idMatiere) throws Exception
    {
        List<VLookTailleType> resultList = vLookTailleTypeRepository.findByIdMatiere(Integer.parseInt(idMatiere));
        
        for(VLookTailleType result : resultList) 
        {
            System.out.println("Valeur: " + result);
        } 
        
        return resultList; 
    }

}
