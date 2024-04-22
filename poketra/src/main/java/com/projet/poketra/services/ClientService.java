package com.projet.poketra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.poketra.models.Client;
import com.projet.poketra.repository.ClientRepository;


import java.util.List;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public void insertClient(Client client)
    {
        clientRepository.save(client);
    }

    public List<Client> getAllClient()
    {
        return clientRepository.findAll();
    }
}
