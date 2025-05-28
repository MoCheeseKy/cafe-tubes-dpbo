package com.tubes_dpbo_cafe.cafe.model.tea_brew;

import com.tubes_dpbo_cafe.cafe.model.category.Tea;

public class JapaneseSteeping extends Tea {

    public JapaneseSteeping(int id, String name, String category, String description, double price, int stock, boolean isBestSeller, String image,
                            String leafOrigin, String brewMethod, Boolean isHerbal) {
        super(id, name,category, description, price, stock, isBestSeller, image, leafOrigin, brewMethod, isHerbal);
    }

    @Override
    public void brew() {
        System.out.println("Teh " + name + " sedang diseduh dengan menggunakan metode Japanese Steeping!");
    }
}
