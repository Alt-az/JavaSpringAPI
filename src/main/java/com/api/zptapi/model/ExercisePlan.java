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


    @OneToMany(mappedBy = "exercisePlan")
    private Set<Exercise> exercise_list;

    public ExercisePlan() {
    }

    public void addExercise(Exercise exercise){
        this.exercise_list.add(exercise);
    }

    @Override
    public String toString() {
        return "ExercisePlan{" +
                "id=" + id +
                ", client=" + client +
                ", exercise_list=" + exercise_list +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
