package com.tubes_dpbo_cafe.cafe.entity;
import com.tubes_dpbo_cafe.cafe.interfaces.IMenu;

import jakarta.persistence.*;

@Entity
@Table(name = "menus")
@Inheritance(strategy = InheritanceType.JOINED)
public class MenuEntity implements IMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String category;

    private String description;

    private double price;

    private int stock;

    @Column(name = "is_best_seller")
    private boolean bestSeller;

    private String image;

    public MenuEntity() {}

    public MenuEntity(Integer id, String name, String category, String description, double price, int stock, boolean bestSeller, String image) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.bestSeller = bestSeller;
        this.image = image;
    }

    // Getters and Setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public boolean bestSeller() { return bestSeller; }
    public void setBestSeller(boolean bestSeller) { bestSeller = bestSeller; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}
