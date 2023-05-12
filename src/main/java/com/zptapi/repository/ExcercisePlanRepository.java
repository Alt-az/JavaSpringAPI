package com.zptapi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.zptapi.model.ExcercisePlan;

public interface ExcercisePlanRepository extends CrudRepository<ExcercisePlan, Long> {
    Optional<ExcercisePlan> findById(Long id);

}
