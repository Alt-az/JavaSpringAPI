package com.api.zptapi.repository;

import com.api.zptapi.model.ExercisePlan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ExcercisePlanRepository extends CrudRepository<ExercisePlan, Long> {
    Optional<ExercisePlan> findById(Long id);

}
