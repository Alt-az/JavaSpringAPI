package com.api.zptapi.repository;

import com.api.zptapi.model.DietPlan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DietPlanRepository extends CrudRepository<DietPlan, Long> {
    Optional<DietPlan> findById(Long id);

    List<DietPlan> findAll();

//    List<DietPlan> findByFood(Food food);

}
