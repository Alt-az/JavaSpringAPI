package com.api.zptapi.controller;

import com.api.zptapi.model.Client;
import com.api.zptapi.model.DietPlan;
import com.api.zptapi.model.Food;
import com.api.zptapi.repository.ClientRepository;
import com.api.zptapi.repository.DietPlanRepository;
import com.api.zptapi.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class DietPlanController {
    @Autowired
    DietPlanRepository dietPlanRepository;

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    FoodRepository foodRepository;

    @GetMapping("/diets/{id}")
    public ResponseEntity<DietPlan> getDietById(@PathVariable("id") Long id) {
        Optional<DietPlan> dietData = dietPlanRepository.findById(id);

        if (dietData.isPresent()) {
            return new ResponseEntity<>(dietData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/food/{id}")
    public ResponseEntity<List<Food>> getFoodByDietId(@PathVariable("id") Long id) {
        List<Food> food_list = foodRepository.findByDietPlanId(id);
        return new ResponseEntity<>(food_list, HttpStatus.OK);
    }

    @GetMapping("/diets")
    public ResponseEntity<List<DietPlan>> getAllDiets() {
        try {
            return new ResponseEntity<>(dietPlanRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/diets/{id}")
    public ResponseEntity<Food> addFood(@PathVariable("id") Long id,
                                             @RequestBody Food food) {
        System.out.println(food);
        Optional<Client> ClientData = clientRepository.findById(id);
        if (ClientData.isPresent()) {
            Optional <DietPlan> DietPlan = dietPlanRepository.findById(ClientData.get().getId());
            if(DietPlan.isPresent()){
                DietPlan dietPlan = DietPlan.get();
                food.setDietPlan(dietPlan);
                return new ResponseEntity<>(foodRepository.save(food), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/foodList/{id}")
    public ResponseEntity<HttpStatus> deleteFoodList(@PathVariable("id") Long id) {
        try {
            List<Food> all = foodRepository.findAll();
            if(!all.isEmpty()) {
                for (Food food : all) {
                    if (Objects.equals(food.getDietPlan().getId(), id)) {
                        foodRepository.delete(food);
                    }
                }
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
