package com.tubes_dpbo_cafe.cafe.controller;

import com.tubes_dpbo_cafe.cafe.entity.MenuEntity;
import com.tubes_dpbo_cafe.cafe.model.ApiResponse;
import com.tubes_dpbo_cafe.cafe.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    // GET /api/menu?search=...&page=...&size=...
    @GetMapping
    public ResponseEntity<ApiResponse<List<MenuEntity>>> getAllMenu(
        @RequestParam(defaultValue = "") String search,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        // Sanitasi input pencarian
        String cleanedSearch = search.replace("\"", "").trim();

        Page<MenuEntity> resultPage = menuService.searchMenus(cleanedSearch, PageRequest.of(page, size));
        ApiResponse<List<MenuEntity>> response = new ApiResponse<>(
            resultPage.getContent(),
            200,
            "Data menu berhasil didapatkan",
            resultPage.getNumber() + 1,
            resultPage.getTotalElements()
        );
        return ResponseEntity.ok(response);
    }

    // GET /api/menu/{id}
    @GetMapping("/{id}")
    public ResponseEntity<MenuEntity> getMenuById(@PathVariable int id) {
        Optional<MenuEntity> menu = menuService.getMenuById(id);
        return menu.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /api/menu
    @PostMapping
    public MenuEntity createMenu(@RequestBody MenuEntity menu) {
        return menuService.createMenu(menu);
    }

    // PUT /api/menu/{id}
    @PutMapping("/{id}")
    public ResponseEntity<MenuEntity> updateMenu(@PathVariable int id, @RequestBody MenuEntity updatedMenu) {
        MenuEntity menu = menuService.updateMenu(id, updatedMenu);
        if (menu != null) {
            return ResponseEntity.ok(menu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/menu/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable int id) {
        boolean deleted = menuService.deleteMenu(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // GET /api/menu/category/{category}
    @GetMapping("/category/{category}")
    public List<MenuEntity> getMenuByCategory(@PathVariable String category) {
        // Sanitasi kategori
        String cleanedCategory = category.replace("\"", "").trim();
        return menuService.getMenuByCategory(cleanedCategory);
    }
}
