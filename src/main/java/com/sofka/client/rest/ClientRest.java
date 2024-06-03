package com.sofka.client.rest;

import com.sofka.client.model.Client;
import com.sofka.client.service.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Client", description = "API para client")
@RestController
@RequestMapping("/api/v1.0")
@CrossOrigin(origins = {"*"})
public class ClientRest {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/client/{id}")
    public Client getClientById(@PathVariable("id") String id) {
        return clientService.getClientById(id);
    }

    @GetMapping("/client/username/{username}")
    public Optional<Object> getClientByUsername(@PathVariable("username") String username) {
        return clientService.getClientByUsername(username);
    }

    @PostMapping("/client")
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

}