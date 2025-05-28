package com.tubes_dpbo_cafe.cafe.controller;

import com.tubes_dpbo_cafe.cafe.entity.MenuEntity;
import com.tubes_dpbo_cafe.cafe.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    // GET /api/menu -> ambil semua menu
    @GetMapping
    public List<MenuEntity> getAllMenu() {
        return menuService.getAllMenu();
    }

    // GET /api/menu/{id} -> ambil menu berdasarkan id
    @GetMapping("/{id}")
    public ResponseEntity<MenuEntity> getMenuById(@PathVariable int id) {
        Optional<MenuEntity> menu = menuService.getMenuById(id);
        return menu.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /api/menu -> buat menu baru
    @PostMapping
    public MenuEntity createMenu(@RequestBody MenuEntity menu) {
        return menuService.createMenu(menu);
    }

    // PUT /api/menu/{id} -> update menu berdasarkan id
    @PutMapping("/{id}")
    public ResponseEntity<MenuEntity> updateMenu(@PathVariable int id, @RequestBody MenuEntity updatedMenu) {
        MenuEntity menu = menuService.updateMenu(id, updatedMenu);
        if (menu != null) {
            return ResponseEntity.ok(menu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/menu/{id} -> hapus menu berdasarkan id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable int id) {
        boolean deleted = menuService.deleteMenu(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // GET /api/menu/category/{category} -> ambil menu berdasarkan kategori
    @GetMapping("/category/{category}")
    public List<MenuEntity> getMenuByCategory(@PathVariable String category) {
        return menuService.getMenuByCategory(category);
    }
}
