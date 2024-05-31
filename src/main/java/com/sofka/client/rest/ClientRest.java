package com.sofka.client.rest;

import com.sofka.client.model.Client;
import com.sofka.client.service.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Client getClientById(String id) {
        return clientService.getClientById(id);
    }

    @PostMapping("/client")
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

}
