package com.tubes_dpbo_cafe.cafe.model.coffe_brew;

import com.tubes_dpbo_cafe.cafe.model.category.Coffee;

public class Tubruk extends Coffee {

    public Tubruk(int id, String name, String category, String description, double price, int stock, boolean isBestSeller, String image,
                  String beanOrigin, String beanType, String roastLevel, int strongLevel, String brewMethod) {
        super(id, name, category, description, price, stock, isBestSeller, image, beanOrigin, beanType, roastLevel, strongLevel, brewMethod);
    }

    @Override
    public void brew() {
        System.out.println("Kopi " + name + " sedang diseduh dengan menggunakan metode Tubruk!");
    }
}
