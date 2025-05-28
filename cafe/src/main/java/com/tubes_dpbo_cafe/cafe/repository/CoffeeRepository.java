package com.tubes_dpbo_cafe.cafe.repository;

import com.tubes_dpbo_cafe.cafe.entity.CoffeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<CoffeeEntity, Integer> {
    List<CoffeeEntity> findByBrewMethod(String brewMethod);
    List<CoffeeEntity> findByStrongLevel(int strongLevel);
}
