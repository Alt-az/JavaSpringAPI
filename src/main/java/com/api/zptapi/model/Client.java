package com.api.zptapi.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "clients")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;

    private String password;
    private int weight;

    private int height;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diet_id")
    private DietPlan dietPlan;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "excercise_id")
    private ExercisePlan exercisePlan;

    public Client() {
    }

    public Client(String email, String password, int weight, int height, DietPlan dietPlan, ExercisePlan exercisePlan) {
        this.email = email;
        this.password = password;
        this.weight = weight;
        this.height = height;
        this.dietPlan = dietPlan;
        this.exercisePlan = exercisePlan;
    }

    public DietPlan getDietPlan() {
        return dietPlan;
    }

    public void setDietPlan(DietPlan dietPlan) {
        this.dietPlan = dietPlan;
    }

    public ExercisePlan getExcercisePlan() {
        return exercisePlan;
    }

    public void setExcercisePlan(ExercisePlan exercisePlan) {
        this.exercisePlan = exercisePlan;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", dietPlan=" + dietPlan +
                ", exercisePlan=" + exercisePlan +
                '}';
    }
}