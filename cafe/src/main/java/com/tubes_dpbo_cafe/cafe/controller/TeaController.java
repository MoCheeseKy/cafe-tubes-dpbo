package com.tubes_dpbo_cafe.cafe.controller;

import com.tubes_dpbo_cafe.cafe.entity.TeaEntity;
import com.tubes_dpbo_cafe.cafe.model.ApiResponse;
import com.tubes_dpbo_cafe.cafe.service.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tea")
public class TeaController {

    @Autowired
    private TeaService teaService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<TeaEntity>>> getAllTea(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "") String search
    ) {
        String cleanedSearch = search.replace("\"", "").trim();
        Page<TeaEntity> teaPage = teaService.getAllTea(page, size, cleanedSearch);
        List<TeaEntity> teas = teaPage.getContent();

        ApiResponse<List<TeaEntity>> response = new ApiResponse<>(
                teas,
                200,
                "Data Tea berhasil diambil",
                teaPage.getNumber() + 1,
                teaPage.getTotalElements()
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public TeaEntity createTea(@RequestBody TeaEntity tea) {
        return teaService.createTea(tea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeaEntity> updateTea(@PathVariable int id, @RequestBody TeaEntity updatedTea) {
        TeaEntity tea = teaService.updateTea(id, updatedTea);
        if (tea != null) {
            return ResponseEntity.ok(tea);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
