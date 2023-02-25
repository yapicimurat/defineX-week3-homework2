package org.example.model;

import java.util.List;

public class Order extends BaseModel{
    private String name;
    private double sum;
    private Customer customer;
    private List<Product> products;

    public Order(String name, List<Product> products, Customer customer){
        this.name = name;
        this.products = products;
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", sum=" + sum +
                ", customer=" + customer.getFirstName() + " " + customer.getLastName() +
                ", products=" + products +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Order order = (Order)obj;

        if(order.name == this.name && order.getCustomer().equals(customer)){
            return true;
        }

        return false;
    }
}
