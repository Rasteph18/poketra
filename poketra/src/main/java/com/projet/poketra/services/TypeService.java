package com.projet.poketra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.poketra.models.Type;
import com.projet.poketra.repository.TypeRepository;

@Service
public class TypeService {
    
    @Autowired
    private TypeRepository typeRepository;

    public void insertType(Type type) throws Exception
    {
        typeRepository.save(type);
    }

    public List<Type> getAllType() throws Exception {
        return typeRepository.findAll();
    }
}
