package org.example.model;

public class Bill extends BaseModel{
    private String name;
    private Order order;
    private double totalPrice;
    public Bill(String name, Order order){
        this.name = name;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrders(Order orders) {
        this.order = order;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object obj) {
        Bill bill = (Bill)obj;

        if(bill.getName() == this.name && bill.getTotalPrice() == this.totalPrice && bill.getOrder().equals(this.order))
        {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "name='" + name + '\'' +
                ", totalPrice=" + totalPrice +
                ", createdAt=" + createdAt +
                '}';
    }
}
