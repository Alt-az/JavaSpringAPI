package com.api.zptapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.api.zptapi.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Optional<Client> findById(Long id);

    List<Client> findByHeight(Integer height);

    List<Client> findByWeight(Integer weight);

    List<Client> findByPassword(String password);

    List<Client> findByEmail(String email);

    List<Client> findAll();

}
