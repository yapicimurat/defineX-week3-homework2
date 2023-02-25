package org.example.constant;

public enum Currency {
    TRY(1),
    EUR(19.99),
    USD(18.89);

    private double val;
    Currency(double val){
        this.val = val;
    }
    public double getPrice(double price){
        return price / val;
    }
}
