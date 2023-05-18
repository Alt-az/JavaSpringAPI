package com.api.zptapi.model;

import com.api.zptapi.model.DietPlan;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "calories")
    private Integer calories;
    @Column(name = "weight")
    private Integer weight;

    @ManyToMany(mappedBy = "food_list")
    private Set<DietPlan> dietPlan;

    public Food() {
        this.dietPlan = new HashSet<>();
    }

    public Food(String name, Integer calories, Integer weight) {
        this.name = name;
        this.calories = calories;
        this.weight = weight;
        this.dietPlan = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setDietPlan(Set<DietPlan> dietPlan) {
        this.dietPlan = dietPlan;
    }

    public Set<DietPlan> getDietPlan() {
        return dietPlan;
    }

    public void addDietPlan(DietPlan dietPlan){
        this.dietPlan.add(dietPlan);
    }
}
