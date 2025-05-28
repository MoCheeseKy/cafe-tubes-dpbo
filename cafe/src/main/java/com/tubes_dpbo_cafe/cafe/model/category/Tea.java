package com.tubes_dpbo_cafe.cafe.model.category;

import com.tubes_dpbo_cafe.cafe.model.base.Menu;

public abstract class Tea extends Menu {
    protected String leafOrigin, brewMethod;
    protected boolean isHerbal;

    public Tea(int id, String name, String category, String description, double price, int stock, boolean isBestSeller, String image,
            String leafOrigin, String brewMethod, Boolean isHerbal) {
        super(id, name,category, description, price, stock, isBestSeller, image);
        this.leafOrigin = leafOrigin;
        this.brewMethod = brewMethod;
        this.isHerbal = isHerbal;
    }

    public abstract void brew();

    public String getLeafOrigin() {
        return leafOrigin;
    }

    public void setLeafOrigin(String leafOrigin) {
        this.leafOrigin = leafOrigin;
    }

    public String getBrewMethod() {
        return brewMethod;
    }

    public void setBrewMethod(String brewMethod) {
        this.brewMethod = brewMethod;
    }
}
