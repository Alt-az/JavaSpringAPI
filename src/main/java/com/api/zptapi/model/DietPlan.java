package com.api.zptapi.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "diet_plan")
public class DietPlan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "dietPlan")
    private Set<Food> food;

    @OneToOne(mappedBy = "dietPlan")
    private Client client;

    public DietPlan() {
        food = new HashSet<>();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addFood(Food meal){
        food.add(meal);
    }

    public void removeFood(Food meal){
        food.remove(meal);
    }
    @Override
    public String toString() {
        return "DietPlan{" +
                "id=" + id +
                ", client=" + client +
                '}';
    }
}
