package com.tubes_dpbo_cafe.cafe.controller;

import com.tubes_dpbo_cafe.cafe.entity.CoffeeEntity;
import com.tubes_dpbo_cafe.cafe.model.ApiResponse;
import com.tubes_dpbo_cafe.cafe.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CoffeeEntity>>> getAllCoffee(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "") String search
    ) {
        String cleanedSearch = search.replace("\"", "").trim();
        Page<CoffeeEntity> coffeePage = coffeeService.getAllCoffee(page, size, cleanedSearch);
        List<CoffeeEntity> coffees = coffeePage.getContent();

        ApiResponse<List<CoffeeEntity>> response = new ApiResponse<>(
                coffees,
                200,
                "Data Coffee berhasil diambil",
                coffeePage.getNumber() + 1,
                coffeePage.getTotalElements()
        );

        return ResponseEntity.ok(response);
    }

    // ✅ Tambahkan: POST
    @PostMapping
    public ResponseEntity<CoffeeEntity> createCoffee(@RequestBody CoffeeEntity coffee) {
        CoffeeEntity savedCoffee = coffeeService.createCoffee(coffee);
        return ResponseEntity.ok(savedCoffee);
    }

    // ✅ Tambahkan: PUT
    @PutMapping("/{id}")
    public ResponseEntity<CoffeeEntity> updateCoffee(@PathVariable int id, @RequestBody CoffeeEntity coffeeDetails) {
        CoffeeEntity updated = coffeeService.updateCoffee(id, coffeeDetails);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

