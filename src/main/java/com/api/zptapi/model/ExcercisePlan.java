package com.api.zptapi.model;

import com.api.zptapi.model.Client;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "excercise_plan")
public class ExcercisePlan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "excercisePlan")
    private Client client;

    public ExcercisePlan() {
    }

    public ExcercisePlan(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "ExcercisePlan{" +
                "id=" + id +
                ", client=" + client +
                '}';
    }
}
