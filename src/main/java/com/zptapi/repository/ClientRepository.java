package com.zptapi.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.zptapi.model.Client;

public interface ClientRepository extends MongoRepository<Client, String> {

    List<Client> findByHeight(Integer height);

    List<Client> findByWeight(Integer weight);

    List<Client> findByPassword(String password);

    List<Client> findByEmail(String email);

}
