package com.api.zptapi.model;

import com.api.zptapi.model.DietPlan;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "food")
public class Food implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "calories")
    private Integer calories;
    @Column(name = "weight")
    private Integer weight;

    @Column(name = "weekday")
    private String weekday;

    @Column(name = "hour")
    private Integer hour;

    @Column(name = "minute")
    private Integer minute;

    @ManyToOne
    @JoinColumn(name="diet_plan_id", nullable=false)
    private DietPlan dietPlan;

    public Food() {

    }

    public Food(Long id, String name, Integer calories, Integer weight, String weekday, Integer hour, Integer minute, DietPlan dietPlan) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.weight = weight;
        this.weekday = weekday;
        this.hour = hour;
        this.minute = minute;
        this.dietPlan = dietPlan;
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

    public DietPlan getDietPlan() {
        return dietPlan;
    }

    public void setDietPlan(DietPlan dietPlan) {
        this.dietPlan = dietPlan;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", weight=" + weight +
                ", weekday='" + weekday + '\'' +
                ", hour=" + hour +
                ", minute=" + minute +
                ", dietPlan=" + dietPlan +
                '}';
    }
}
