package com.api.zptapi.repository;

import com.zptapi.model.Food;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends CrudRepository<Food, Long> {
    Optional<Food> findById(Long id);

    List<Food> findByName(String name);

    List<Food> findByWeight(Integer weight);

    List<Food> findByCalories(Integer calories);
}
