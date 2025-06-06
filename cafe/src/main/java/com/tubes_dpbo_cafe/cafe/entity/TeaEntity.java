package com.tubes_dpbo_cafe.cafe.entity;
import com.tubes_dpbo_cafe.cafe.interfaces.ITea;

import jakarta.persistence.*;

@Entity
@Table(name = "tea")
public class TeaEntity extends MenuEntity implements ITea {

    @Column(name = "leaf_origin")
    private String leafOrigin;

    @Column(name = "is_herbal")
    private boolean isHerbal;

    @Column(name = "brew_method")
    private String brewMethod;

    public TeaEntity() {}

    public TeaEntity(
            Integer id,
            String name,
            String category,
            String description,
            double price,
            int stock,
            boolean bestSeller,
            String image,
            String leafOrigin,
            boolean isHerbal,
            String brewMethod
    ) {
        super(id, name, category, description, price, stock, bestSeller, image);
        this.leafOrigin = leafOrigin;
        this.isHerbal = isHerbal;
        this.brewMethod = brewMethod;
    }

    public String getLeafOrigin() { return leafOrigin; }
    public void setLeafOrigin(String leafOrigin) { this.leafOrigin = leafOrigin; }

    public boolean isHerbal() { return isHerbal; }
    public void setHerbal(boolean herbal) { isHerbal = herbal; }

    public String getBrewMethod() { return brewMethod; }
    public void setBrewMethod(String brewMethod) { this.brewMethod = brewMethod; }
}
