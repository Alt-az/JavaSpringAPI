package com.api.zptapi.repository;

import com.api.zptapi.model.Exercise;
import com.api.zptapi.model.Food;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface ExerciseRepository extends CrudRepository<Exercise,Long> {
    List<Exercise> findAll();
    default List<Exercise> findByExercisePlanId(Long id){
        List<Exercise> all = this.findAll();
        List<Exercise> result = new ArrayList<>();
        for(Exercise exercise: all){
            if(Objects.equals(exercise.getExercisePlan().getId(), id)){
                result.add(exercise);
            }
        }
        return result;
    }
}
