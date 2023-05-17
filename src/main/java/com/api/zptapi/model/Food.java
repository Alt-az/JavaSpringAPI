package com.api.zptapi.model;

import com.zptapi.model.DietPlan;
import jakarta.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "diet_id")
    private DietPlan diet;
}
