package com.tubes_dpbo_cafe.cafe.service;

import com.tubes_dpbo_cafe.cafe.entity.MenuEntity;
import com.tubes_dpbo_cafe.cafe.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    // Ambil semua menu (tanpa paging)
    public List<MenuEntity> getAllMenu() {
        return menuRepository.findAll();
    }

    // Ambil menu berdasarkan ID
    public Optional<MenuEntity> getMenuById(int id) {
        return menuRepository.findById(id);
    }

    // Buat menu baru
    public MenuEntity createMenu(MenuEntity menu) {
        return menuRepository.save(menu);
    }

    // Perbarui menu berdasarkan ID
    public MenuEntity updateMenu(int id, MenuEntity updatedMenu) {
        return menuRepository.findById(id).map(menu -> {
            menu.setName(updatedMenu.getName());
            menu.setCategory(updatedMenu.getCategory());
            menu.setDescription(updatedMenu.getDescription());
            menu.setPrice(updatedMenu.getPrice());
            menu.setStock(updatedMenu.getStock());
            menu.setBestSeller(updatedMenu.bestSeller());
            menu.setImage(updatedMenu.getImage());
            return menuRepository.save(menu);
        }).orElse(null);
    }

    // Hapus menu berdasarkan ID
    public boolean deleteMenu(int id) {
        if (menuRepository.existsById(id)) {
            menuRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Ambil menu berdasarkan kategori
    public List<MenuEntity> getMenuByCategory(String category) {
        return menuRepository.findByCategoryIgnoreCase(category.trim().replace("\"", ""));
    }

    /**
     * Cari menu berdasarkan nama (keyword pencarian), dengan pagination
     */
    public Page<MenuEntity> searchMenus(String search, Pageable pageable) {
        String cleanedSearch = search.trim().replace("\"", "");
        return menuRepository.findByNameContainingIgnoreCase(cleanedSearch, pageable);
    }
}
