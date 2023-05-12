package com.zptapi.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "food")
public class Food {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "calories")
    private Integer calories;
    @Column(name = "weight")
    private Integer weight;

    @ManyToOne
    @JoinColumn(name = "diet_plan_id", nullable = false)
    private DietPlan diet;
}
