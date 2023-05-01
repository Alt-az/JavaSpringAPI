package com.zptapi.controller;

import java.util.List;
import com.zptapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zptapi.model.Client;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientRepository ClientRepository;

    @GetMapping("/Clients")
    public ResponseEntity<List<Client>> getAllClients(@RequestParam(required = false) String title) {

    }

    @GetMapping("/Clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") String id) {

    }

    @PostMapping("/Clients")
    public ResponseEntity<Client> createClient(@RequestBody Client Client) {

    }

    @PutMapping("/Clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") String id, @RequestBody Client Client) {

    }

    @DeleteMapping("/Clients/{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable("id") String id) {

    }

    @DeleteMapping("/Clients")
    public ResponseEntity<HttpStatus> deleteAllClients() {

    }

    @GetMapping("/Clients/weight")
    public ResponseEntity<List<Client>> findByPublished() {

    }

}
