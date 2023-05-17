package com.api.zptapi.repository;

import com.api.zptapi.model.ExcercisePlan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ExcercisePlanRepository extends CrudRepository<ExcercisePlan, Long> {
    Optional<ExcercisePlan> findById(Long id);

}
