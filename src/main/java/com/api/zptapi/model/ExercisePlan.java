package com.api.zptapi.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "exercise_plan")
public class ExercisePlan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "exercisePlan")
    private Client client;

    @ManyToMany
    @JoinTable(
            name = "exercise_list",
            joinColumns = @JoinColumn(name = "exercise_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_plan_id"))
    private Set<Exercise> exercise_list;

    public ExercisePlan() {
    }

    public ExercisePlan(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "ExercisePlan{" +
                "id=" + id +
                ", client=" + client +
                '}';
    }
}
