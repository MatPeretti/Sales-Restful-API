package com.restfulapi.sales.controller;

import com.restfulapi.sales.domain.entity.Client;
import com.restfulapi.sales.domain.repository.Clients;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/client")
public class ClientController {
    public Clients clients;

    public ClientController(Clients clients){
        this.clients = clients;
    }

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity getClientById(@PathVariable Integer id ){
        Optional<Client> client = clients.findById(id);

        if(client.isPresent()){
            return ResponseEntity.ok( client.get() );
        }

        return ResponseEntity.notFound().build();
    }
}
