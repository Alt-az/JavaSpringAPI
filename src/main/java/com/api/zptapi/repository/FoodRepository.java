package com.api.zptapi.repository;

import com.api.zptapi.model.Food;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface FoodRepository extends CrudRepository<Food, Long> {
    Optional<Food> findById(Long id);

    List<Food> findByName(String name);

    List<Food> findByWeight(Integer weight);

    List<Food> findByCalories(Integer calories);

    List<Food> findAll();

    default List<Food> findByDietPlanId(Long id){
        List<Food> all = this.findAll();
        List<Food> result = new ArrayList<>();
        for(Food food: all){
            if(Objects.equals(food.getDietPlan().getId(), id)){
                result.add(food);
            }
        }
        return result;
    }

}
