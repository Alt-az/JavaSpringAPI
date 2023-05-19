package com.api.zptapi.model;

import jakarta.persistence.*;

import java.util.Set;
@Entity
@Table(name = "exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "muscle")
    private String muscle;
    @Column(name = "difficulty")
    private String difficulty;

    @ManyToMany(mappedBy = "exercise_list")
    private Set<ExercisePlan> ExercisePlan;

}
