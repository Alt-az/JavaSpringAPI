package com.api.zptapi.controller;

import com.api.zptapi.model.Client;
import com.api.zptapi.model.DietPlan;
import com.api.zptapi.repository.DietPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DietPlanController {
    @Autowired
    DietPlanRepository dietPlanRepository;

    @GetMapping("/diets/{id}")
    public ResponseEntity<DietPlan> getDietById(@PathVariable("id") Long id) {
        Optional<DietPlan> dietData = dietPlanRepository.findById(id);

        if (dietData.isPresent()) {
            return new ResponseEntity<>(dietData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/diets")
    public ResponseEntity<List<DietPlan>> getAllDiets() {
        try {
            return new ResponseEntity<>(dietPlanRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
