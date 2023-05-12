package com.zptapi.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "diet_plan")
public class DietPlan {
    @Id
    @Column(name = "client_id")
    private Long id;

    @OneToMany(mappedBy = "diet_plan")
    private Set<Food> food;

    @OneToOne
    @MapsId
    @JoinColumn(name = "client_id")
    private Client client;
}
