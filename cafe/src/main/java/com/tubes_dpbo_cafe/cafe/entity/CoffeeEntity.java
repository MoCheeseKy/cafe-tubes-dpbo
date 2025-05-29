package com.tubes_dpbo_cafe.cafe.entity;
import com.tubes_dpbo_cafe.cafe.interfaces.ICoffee;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "coffee")
public class CoffeeEntity extends MenuEntity implements ICoffee {

    @Column(name = "bean_origin")
    private String beanOrigin;

    @Column(name = "bean_type")
    private String beanType;

    @Column(name = "roast_level")
    private String roastLevel;

    @Min(1)
    @Max(5)
    @Column(name = "strong_level")
    private int strongLevel; // Skala 1 - 5

    @Column(name = "brew_method")
    private String brewMethod;

    public CoffeeEntity() {}

    public CoffeeEntity(Integer id, String name, String category, String description, double price, int stock,
                        boolean bestSeller, String image, String beanOrigin, String beanType, String roastLevel,
                        int strongLevel, String brewMethod) {
        super(id, name, category, description, price, stock, bestSeller, image);
        this.beanOrigin = beanOrigin;
        this.beanType = beanType;
        this.roastLevel = roastLevel;
        this.strongLevel = strongLevel;
        this.brewMethod = brewMethod;
    }

    // Getters and Setters
    public String getBeanOrigin() { return beanOrigin; }
    public void setBeanOrigin(String beanOrigin) { this.beanOrigin = beanOrigin; }

    public String getBeanType() { return beanType; }
    public void setBeanType(String beanType) { this.beanType = beanType; }

    public String getRoastLevel() { return roastLevel; }
    public void setRoastLevel(String roastLevel) { this.roastLevel = roastLevel; }

    public int getStrongLevel() { return strongLevel; }
    public void setStrongLevel(int strongLevel) { this.strongLevel = strongLevel; }

    public String getBrewMethod() { return brewMethod; }
    public void setBrewMethod(String brewMethod) { this.brewMethod = brewMethod; }
}
