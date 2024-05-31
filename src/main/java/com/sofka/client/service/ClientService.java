package com.sofka.client.service;

import com.sofka.client.model.Client;
import com.sofka.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(String id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public Optional<Object> getClientByUsername(String username) {
        try {
            return clientRepository.findByUsername(username);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar el cliente");
        }
    }

    public Client addClient(Client client) {
        //validate if the client already exists
        if (clientRepository.existsById(client.getUsername())) {
            throw new RuntimeException("Ya existe un cliente con ese username");
        }
        return clientRepository.save(client);
    }
}
