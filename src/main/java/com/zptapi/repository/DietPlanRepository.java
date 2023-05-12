package com.zptapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.zptapi.model.DietPlan;
import com.zptapi.model.Food;

public interface DietPlanRepository extends CrudRepository<DietPlan, Long> {
    Optional<DietPlan> findById(Long id);

    List<DietPlan> findByFood(Food food);

}
