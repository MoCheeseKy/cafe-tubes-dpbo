package com.tubes_dpbo_cafe.cafe.service;

import com.tubes_dpbo_cafe.cafe.entity.MenuEntity;
import com.tubes_dpbo_cafe.cafe.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<MenuEntity> getAllMenu() {
        return menuRepository.findAll();
    }

    public Optional<MenuEntity> getMenuById(int id) {
        return menuRepository.findById(id);
    }

    public MenuEntity createMenu(MenuEntity menu) {
        return menuRepository.save(menu);
    }

    public MenuEntity updateMenu(int id, MenuEntity updatedMenu) {
        return menuRepository.findById(id).map(menu -> {
            menu.setName(updatedMenu.getName());
            menu.setCategory(updatedMenu.getCategory());
            menu.setDescription(updatedMenu.getDescription());
            menu.setPrice(updatedMenu.getPrice());
            menu.setStock(updatedMenu.getStock());
            menu.setBestSeller(updatedMenu.isBestSeller());
            menu.setImage(updatedMenu.getImage());
            return menuRepository.save(menu);
        }).orElse(null);
    }

    public boolean deleteMenu(int id) {
        if (menuRepository.existsById(id)) {
            menuRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<MenuEntity> getMenuByCategory(String category) {
        return menuRepository.findByCategoryIgnoreCase(category);
    }
}
