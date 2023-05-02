package com.zptapi.controller;

import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.zptapi.model.Client;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/Clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") String id) {
        Optional<Client> clientData = clientRepository.findById(id);

        if (clientData.isPresent()) {
            return new ResponseEntity<>(clientData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/Clients")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        try {
            Client _client = clientRepository
                    .save(new Client(client.getEmail(), client.getLogin(), client.getWeight(), client.getHeight()));
            return new ResponseEntity<>(_client, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/Clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") String id, @RequestBody Client Client) {
        Optional<Client> ClientData = clientRepository.findById(id);

        if (ClientData.isPresent()) {
            Client _client = ClientData.get();
            _client.setWeight(Client.getWeight());
            _client.setHeight(Client.getHeight());
            _client.setEmail(Client.getEmail());
            _client.setLogin(Client.getLogin());
            return new ResponseEntity<>(clientRepository.save(_client), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Clients/{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable("id") String id) {
        try {
            clientRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/Clients")
    public ResponseEntity<HttpStatus> deleteAllClients() {
        try {
            clientRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
