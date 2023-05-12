package com.zptapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.zptapi.model.Food;

public interface FoodRepository extends CrudRepository<Food, Long> {
    Optional<Food> findById(Long id);

    List<Food> findByName(String name);

    List<Food> findByWeight(Integer weight);

    List<Food> findByCalories(Integer calories);
}
