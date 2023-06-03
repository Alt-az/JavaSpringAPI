package com.api.zptapi.controller;

import com.api.zptapi.model.Client;
import com.api.zptapi.model.Exercise;
import com.api.zptapi.model.ExercisePlan;
import com.api.zptapi.model.Food;
import com.api.zptapi.repository.ClientRepository;
import com.api.zptapi.repository.DietPlanRepository;
import com.api.zptapi.repository.ExercisePlanRepository;
import com.api.zptapi.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ExerciseController {
    @Autowired
    DietPlanRepository dietPlanRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ExercisePlanRepository exercisePlanRepository;

    @Autowired
    ExerciseRepository exerciseRepository;

    @PutMapping("/exercises/{id}")
    public ResponseEntity<Exercise> addExercise(@PathVariable("id") Long id,
                                        @RequestBody Exercise exercise) {
        System.out.println(exercise);
        Optional<Client> ClientData = clientRepository.findById(id);
        if (ClientData.isPresent()) {
            Optional<ExercisePlan> exercisePlan = exercisePlanRepository.findById(ClientData.get().getId());
            if(exercisePlan.isPresent()){
                ExercisePlan _exercisePlan = exercisePlan.get();
                exercise.setExercisePlan(_exercisePlan);
                return new ResponseEntity<>(exerciseRepository.save(exercise), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/exercises/{id}")
    public ResponseEntity<List<Exercise>> getExerciseByDietId(@PathVariable("id") Long id) {
        List<Exercise> food_list = exerciseRepository.findByExercisePlanId(id);
        return new ResponseEntity<>(food_list, HttpStatus.OK);
    }

    @DeleteMapping("/exercises/{id}")
    public ResponseEntity<HttpStatus> deleteExerciseList(@PathVariable("id") Long id) {
        try {
            List<Exercise> all = exerciseRepository.findAll();
            if(!all.isEmpty()) {
                for (Exercise exercise : all) {
                    if (Objects.equals(exercise.getExercisePlan().getId(), id)) {
                        exerciseRepository.delete(exercise);
                    }
                }
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
