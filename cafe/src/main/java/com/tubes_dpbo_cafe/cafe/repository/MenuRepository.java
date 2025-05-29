package com.tubes_dpbo_cafe.cafe.repository;

import com.tubes_dpbo_cafe.cafe.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {

    // Ambil semua menu berdasarkan kategori (case insensitive)
    List<MenuEntity> findByCategoryIgnoreCase(String category);
    Page<MenuEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
