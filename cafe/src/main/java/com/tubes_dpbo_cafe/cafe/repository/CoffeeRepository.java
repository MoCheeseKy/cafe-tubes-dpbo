package com.tubes_dpbo_cafe.cafe.repository;

import com.tubes_dpbo_cafe.cafe.entity.CoffeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<CoffeeEntity, Integer> {
    Page<CoffeeEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
