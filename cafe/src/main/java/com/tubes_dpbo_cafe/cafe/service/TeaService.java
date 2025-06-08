package com.tubes_dpbo_cafe.cafe.service;

import com.tubes_dpbo_cafe.cafe.entity.TeaEntity;
import com.tubes_dpbo_cafe.cafe.repository.TeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TeaService {

    @Autowired
    private TeaRepository teaRepository;

    public Page<TeaEntity> getAllTea(int page, int size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (search != null && !search.trim().isEmpty()) {
            return teaRepository.findByNameContainingIgnoreCase(search, pageable);
        } else {
            return teaRepository.findAll(pageable);
        }
    }

    public TeaEntity createTea(TeaEntity tea) {
        tea.setCategory("Tea"); 
        return teaRepository.save(tea);
    }

    public TeaEntity updateTea(int id, TeaEntity updatedTea) {
        return teaRepository.findById(id).map(existing -> {
            existing.setName(updatedTea.getName());
            existing.setCategory("Tea");
            existing.setDescription(updatedTea.getDescription());
            existing.setPrice(updatedTea.getPrice());
            existing.setStock(updatedTea.getStock());
            existing.setBestSeller(updatedTea.isBestSeller());
            existing.setImage(updatedTea.getImage());
            existing.setLeafOrigin(updatedTea.getLeafOrigin());
            existing.setHerbal(updatedTea.isHerbal());
            existing.setBrewMethod(updatedTea.getBrewMethod());
            return teaRepository.save(existing);
        }).orElse(null);
    }
}
