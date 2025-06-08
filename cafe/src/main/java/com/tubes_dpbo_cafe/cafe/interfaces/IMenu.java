package com.tubes_dpbo_cafe.cafe.interfaces;

public interface IMenu {
    String getName();
    String getCategory();
    String getDescription();
    double getPrice();
    int getStock();
    boolean isBestSeller();
    String getImage();

    void setName(String name);
    void setCategory(String category);
    void setDescription(String description);
    void setPrice(double price);
    void setStock(int stock);
    void setBestSeller(boolean bestSeller);
    void setImage(String image);
}
