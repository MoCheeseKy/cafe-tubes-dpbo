package com.tubes_dpbo_cafe.cafe.controller;

import com.tubes_dpbo_cafe.cafe.entity.TeaEntity;
import com.tubes_dpbo_cafe.cafe.service.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tea")
public class TeaController {

    @Autowired
    private TeaService teaService;

    @GetMapping
    public List<TeaEntity> getAllTea() {
        return teaService.getAllTea();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeaEntity> getTeaById(@PathVariable int id) {
        Optional<TeaEntity> tea = teaService.getTeaById(id);
        return tea.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.notFound().build());
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTea(@PathVariable int id) {
        boolean deleted = teaService.deleteTea(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/origin/{leafOrigin}")
    public List<TeaEntity> getTeaByLeafOrigin(@PathVariable String leafOrigin) {
        return teaService.getTeaByLeafOrigin(leafOrigin);
    }

    @GetMapping("/brew-method/{brewMethod}")
    public List<TeaEntity> getTeaByBrewMethod(@PathVariable String brewMethod) {
        return teaService.getTeaByBrewMethod(brewMethod);
    }

    @GetMapping("/herbal/{isHerbal}")
    public List<TeaEntity> getTeaByIsHerbal(@PathVariable boolean isHerbal) {
        return teaService.getTeaByIsHerbal(isHerbal);
    }

}
