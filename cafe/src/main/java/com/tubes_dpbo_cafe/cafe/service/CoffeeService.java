package com.tubes_dpbo_cafe.cafe.service;

import com.tubes_dpbo_cafe.cafe.entity.CoffeeEntity;
import com.tubes_dpbo_cafe.cafe.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    public Page<CoffeeEntity> getAllCoffee(int page, int size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (search != null && !search.trim().isEmpty()) {
            return coffeeRepository.findByNameContainingIgnoreCase(search, pageable);
        } else {
            return coffeeRepository.findAll(pageable);
        }
    }

    // ✅ Tambahkan
    public CoffeeEntity createCoffee(CoffeeEntity coffee) {
        // Akan otomatis masuk ke tabel `menus` dan `coffee` karena inheritance JOINED
        return coffeeRepository.save(coffee);
    }

    // ✅ Tambahkan
    public CoffeeEntity updateCoffee(int id, CoffeeEntity coffeeDetails) {
        return coffeeRepository.findById(id).map(coffee -> {
            coffee.setName(coffeeDetails.getName());
            coffee.setCategory(coffeeDetails.getCategory());
            coffee.setDescription(coffeeDetails.getDescription());
            coffee.setPrice(coffeeDetails.getPrice());
            coffee.setStock(coffeeDetails.getStock());
            coffee.setImage(coffeeDetails.getImage());
            coffee.setBestSeller(coffeeDetails.bestSeller());

            coffee.setBeanOrigin(coffeeDetails.getBeanOrigin());
            coffee.setBeanType(coffeeDetails.getBeanType());
            coffee.setRoastLevel(coffeeDetails.getRoastLevel());
            coffee.setStrongLevel(coffeeDetails.getStrongLevel());
            coffee.setBrewMethod(coffeeDetails.getBrewMethod());

            return coffeeRepository.save(coffee);
        }).orElse(null);
    }
}
