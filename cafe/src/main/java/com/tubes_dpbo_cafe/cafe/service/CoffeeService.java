package com.tubes_dpbo_cafe.cafe.service;

import com.tubes_dpbo_cafe.cafe.entity.CoffeeEntity;
import com.tubes_dpbo_cafe.cafe.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    public List<CoffeeEntity> getAllCoffee() {
        return coffeeRepository.findAll();
    }

    public Optional<CoffeeEntity> getCoffeeById(int id) {
        return coffeeRepository.findById(id);
    }

    public CoffeeEntity createCoffee(CoffeeEntity coffee) {
        return coffeeRepository.save(coffee);
    }

    public CoffeeEntity updateCoffee(int id, CoffeeEntity updatedCoffee) {
        return coffeeRepository.findById(id).map(existing -> {
            updatedCoffee.setId(existing.getId());
            return coffeeRepository.save(updatedCoffee);
        }).orElse(null);
    }

    public boolean deleteCoffee(int id) {
        if (coffeeRepository.existsById(id)) {
            coffeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<CoffeeEntity> getCoffeeByBrewMethod(String brewMethod) {
        return coffeeRepository.findByBrewMethod(brewMethod);
    }

    public List<CoffeeEntity> getCoffeeByStrongLevel(int level) {
        return coffeeRepository.findByStrongLevel(level);
    }
}
