package com.tubes_dpbo_cafe.cafe.repository;

import com.tubes_dpbo_cafe.cafe.entity.TeaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeaRepository extends JpaRepository<TeaEntity, Integer> {
    Page<TeaEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
