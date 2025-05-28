package com.tubes_dpbo_cafe.cafe.model.category;

import com.tubes_dpbo_cafe.cafe.model.base.Menu;

public abstract class Coffee extends Menu {
    protected String beanOrigin, beanType, roastLevel, brewMethod;
    protected int strongLevel;

    public Coffee(int id, String name, String category, String description, double price, int stock, boolean isBestSeller, String image,
                  String beanOrigin, String beanType, String roastLevel, int strongLevel, String brewMethod) {
        super(id, name, category, description, price, stock, isBestSeller, image);
        this.beanOrigin = beanOrigin;
        this.beanType = beanType;
        this.roastLevel = roastLevel;
        this.strongLevel = strongLevel;
        this.brewMethod = brewMethod;
    }

    public abstract void brew();

    public String getBeanOrigin() {
        return beanOrigin;
    }

    public void setBeanOrigin(String beanOrigin) {
        this.beanOrigin = beanOrigin;
    }

    public String getBeanType() {
        return beanType;
    }

    public void setBeanType(String beanType) {
        this.beanType = beanType;
    }

    public String getRoastLevel() {
        return roastLevel;
    }

    public void setRoastLevel(String roastLevel) {
        this.roastLevel = roastLevel;
    }

    public int isStrongLevel() {
        return strongLevel;
    }

    public void setStrongLevel(int strongLevel) {
        this.strongLevel = strongLevel;
    }
}
