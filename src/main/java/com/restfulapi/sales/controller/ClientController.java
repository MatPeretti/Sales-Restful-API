package com.restfulapi.sales.controller;

import com.restfulapi.sales.domain.entity.Client;
import com.restfulapi.sales.domain.repository.Clients;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/client")
public class ClientController {
    public Clients clients;

    public ClientController(Clients clients) {
        this.clients = clients;
    }

    @GetMapping("{id}")
    public ResponseEntity getClientById(@PathVariable Integer id) {
        Optional<Client> client = clients.findById(id);

        if (client.isPresent()) {
            return ResponseEntity.ok(client.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Client client) {
        Client savedClient = clients.save(client);
        return ResponseEntity.ok(savedClient);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Client> client = clients.findById(id);

        if (client.isPresent()) {
            clients.delete(client.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Client client) {
        return clients.findById(id)
                .map(existingClient -> {
                    client.setId(existingClient.getId());
                    clients.save(client);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
