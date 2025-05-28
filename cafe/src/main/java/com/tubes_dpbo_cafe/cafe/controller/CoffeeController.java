package com.tubes_dpbo_cafe.cafe.controller;

import com.tubes_dpbo_cafe.cafe.entity.CoffeeEntity;
import com.tubes_dpbo_cafe.cafe.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping
    public List<CoffeeEntity> getAllCoffee() {
        return coffeeService.getAllCoffee();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoffeeEntity> getCoffeeById(@PathVariable int id) {
        Optional<CoffeeEntity> coffee = coffeeService.getCoffeeById(id);
        return coffee.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CoffeeEntity createCoffee(@RequestBody CoffeeEntity coffee) {
        return coffeeService.createCoffee(coffee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoffeeEntity> updateCoffee(@PathVariable int id, @RequestBody CoffeeEntity updatedCoffee) {
        CoffeeEntity coffee = coffeeService.updateCoffee(id, updatedCoffee);
        if (coffee != null) {
            return ResponseEntity.ok(coffee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoffee(@PathVariable int id) {
        boolean deleted = coffeeService.deleteCoffee(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/brew-method/{method}")
    public List<CoffeeEntity> getCoffeeByBrewMethod(@PathVariable String method) {
        return coffeeService.getCoffeeByBrewMethod(method);
    }

    @GetMapping("/strong-level/{level}")
    public List<CoffeeEntity> getCoffeeByStrongLevel(@PathVariable int level) {
        return coffeeService.getCoffeeByStrongLevel(level);
    }
}
