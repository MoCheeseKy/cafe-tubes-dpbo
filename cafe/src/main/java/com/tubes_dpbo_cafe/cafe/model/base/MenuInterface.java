package com.tubes_dpbo_cafe.cafe.model.base;

public interface MenuInterface {
    void setId(int id);
    void setName(String name);
    void setDescription(String description);
    void setPrice(double price);
    void setStock(int stock);
    void setBestSeller(boolean isBestSeller);
    void setImage(String image);
}