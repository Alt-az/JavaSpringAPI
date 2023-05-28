package com.api.zptapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.api.zptapi.model.DietPlan;
import com.api.zptapi.model.ExercisePlan;
import com.api.zptapi.repository.ClientRepository;

import com.api.zptapi.repository.DietPlanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.util.comparator.NullSafeComparator;
import org.springframework.web.bind.annotation.*;

import com.api.zptapi.model.Client;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    DietPlanRepository dietPlanRepository;

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id) {
        Optional<Client> clientData = clientRepository.findById(id);

        if (clientData.isPresent()) {
            return new ResponseEntity<>(clientData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getClientByEmail(@RequestParam(required = false) String email) {
        try {
            if(email != null) {
                List<Client> clients = new ArrayList<Client>();

                clientRepository.findByEmail(email).forEach(clients::add);

                if (clients.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }

                return new ResponseEntity<>(clients, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(clientRepository.findAll(), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/clients")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        try {
            Client _client = clientRepository
                    .save(new Client(client.getEmail(), client.getPassword(), client.getWeight(),
                            client.getHeight(),new DietPlan(),new ExercisePlan()));
            dietPlanRepository.save(_client.getDietPlan());
            System.out.println(_client.getDietPlan());
            return new ResponseEntity<>(_client, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long id,
            @RequestBody Client Client) {
        Optional<Client> ClientData = clientRepository.findById(id);
        if (ClientData.isPresent()) {
            String empty = "";
            Client _client = ClientData.get();
            if(Client.getWeight()!=0){
                _client.setWeight(Client.getWeight());
            }
            if(Client.getHeight()!=0){
                _client.setHeight(Client.getHeight());
            }
            if(Client.getEmail()!=null && !empty.equals(Client.getEmail())){
                _client.setEmail(Client.getEmail());
            }
            if(Client.getPassword()!=null && !empty.equals(Client.getPassword())){
                _client.setPassword(Client.getPassword());
            }
            if(Client.getDietPlan()!=null){
                _client.setDietPlan(Client.getDietPlan());
            }
            return new ResponseEntity<>(clientRepository.save(_client), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable("id") Long id) {
        try {
            clientRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/clients")
    public ResponseEntity<HttpStatus> deleteAllClients() {
        try {
            clientRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
