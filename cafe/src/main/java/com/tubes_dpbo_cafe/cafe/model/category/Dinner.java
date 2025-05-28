package com.tubes_dpbo_cafe.cafe.model.category;

import com.tubes_dpbo_cafe.cafe.model.base.Menu;

public class Dinner extends Menu {
    public Dinner(int id, String name, String category, String description, double price, int stock, boolean isBestSeller, String image) {
        super(id, name, category, description, price, stock, isBestSeller, image);
    }
}
