package com.api.zptapi.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "exercise")
public class Exercise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "muscle")
    private String muscle;
    @Column(name = "difficulty")
    private String difficulty;

    @Column(name = "weekday")
    private String weekday;

    @Column(name = "hour")
    private Integer hour;

    @Column(name = "minute")
    private Integer minute;

    @ManyToOne
    @JoinColumn(name="exercise_plan_id", nullable=false)
    private ExercisePlan exercisePlan;

    public Exercise(Long id, String name, String muscle, String difficulty, ExercisePlan exercisePlans) {
        this.id = id;
        this.name = name;
        this.muscle = muscle;
        this.difficulty = difficulty;
        this.exercisePlan = exercisePlans;
    }

    public void setExercisePlan(ExercisePlan exercisePlan) {
        this.exercisePlan = exercisePlan;
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

    public String getMuscle() {
        return muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
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

    public ExercisePlan getExercisePlan() {
        return exercisePlan;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", muscle='" + muscle + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", weekday='" + weekday + '\'' +
                ", hour=" + hour +
                ", minute=" + minute +
                ", exercisePlan=" + exercisePlan +
                '}';
    }
}
