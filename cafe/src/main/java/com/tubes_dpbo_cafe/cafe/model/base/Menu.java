package com.tubes_dpbo_cafe.cafe.model.base;

public abstract class Menu implements MenuInterface {
    protected int id, stock;
    protected String name, category,description, image;
    protected double price;
    protected boolean isBestSeller;

    public Menu(int id, String name, String category, String description, double price, int stock, boolean isBestSeller, String image) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.isBestSeller = isBestSeller;
        this.image = image;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

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

    public boolean isBestSeller() { return isBestSeller; }
    public void setBestSeller(boolean isBestSeller) { this.isBestSeller = isBestSeller; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public void showProductDetails() {
        System.out.println((isBestSeller ? "(Signature) " : "") + name + " - " + description + " | Rp" + price);
    }
}
