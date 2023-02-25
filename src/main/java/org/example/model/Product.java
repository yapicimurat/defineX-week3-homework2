package org.example.model;

public class Product extends BaseModel{
    private String name;
    private Brand brand;
    private double price;

    public Product(String name, double price, Brand brand){
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", brand=" + brand.getName() +
                ", company=" + brand.getCompany().getName() +
                ", price=" + price +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Product product = (Product)obj;

        if(product.getName().equals(this.name) && product.getBrand().equals(this.brand)){
            return true;
        }
        return false;
    }
}
