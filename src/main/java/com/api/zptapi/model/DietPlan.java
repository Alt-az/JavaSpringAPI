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

    @ManyToMany
    @JoinTable(
            name = "food_list",
            joinColumns = @JoinColumn(name = "food_id"),
            inverseJoinColumns = @JoinColumn(name = "diet_id"))
    private Set<Food> food_list;

    @OneToOne(mappedBy = "dietPlan")
    private Client client;

    public DietPlan() {
        food_list = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addFood(Food meal){
        food_list.add(meal);
    }

    public void removeFood(Food meal){
        food_list.remove(meal);
    }

    @Override
    public String toString() {
        return "DietPlan{" +
                "id=" + id +
                ", food_list=" + food_list +
                ", client=" + client +
                '}';
    }
}
