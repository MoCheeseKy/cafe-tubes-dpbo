package com.tubes_dpbo_cafe.cafe.service;

import com.tubes_dpbo_cafe.cafe.entity.TeaEntity;
import com.tubes_dpbo_cafe.cafe.repository.TeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeaService {

    @Autowired
    private TeaRepository teaRepository;

    public List<TeaEntity> getAllTea() {
        return teaRepository.findAll();
    }

    public List<TeaEntity> getTeaByBrewMethod(String brewMethod) {
        return teaRepository.findByBrewMethod(brewMethod);
    }

    public List<TeaEntity> getTeaByIsHerbal(boolean isHerbal) {
        return teaRepository.findByIsHerbal(isHerbal);
    }


    public Optional<TeaEntity> getTeaById(int id) {
        return teaRepository.findById(id);
    }

    public TeaEntity createTea(TeaEntity tea) {
        return teaRepository.save(tea);
    }

    public TeaEntity updateTea(int id, TeaEntity updatedTea) {
        Optional<TeaEntity> optionalTea = teaRepository.findById(id);
        if (optionalTea.isPresent()) {
            TeaEntity existingTea = optionalTea.get();
            existingTea.setName(updatedTea.getName());
            existingTea.setCategory(updatedTea.getCategory());
            existingTea.setDescription(updatedTea.getDescription());
            existingTea.setPrice(updatedTea.getPrice());
            existingTea.setStock(updatedTea.getStock());
            existingTea.setBestSeller(updatedTea.isBestSeller());
            existingTea.setImage(updatedTea.getImage());
            existingTea.setLeafOrigin(updatedTea.getLeafOrigin());
            existingTea.setHerbal(updatedTea.isHerbal());
            existingTea.setBrewMethod(updatedTea.getBrewMethod());
            return teaRepository.save(existingTea);
        } else {
            return null;
        }
    }

    public boolean deleteTea(int id) {
        if (teaRepository.existsById(id)) {
            teaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<TeaEntity> getTeaByLeafOrigin(String leafOrigin) {
        return teaRepository.findByLeafOrigin(leafOrigin);
    }
}
