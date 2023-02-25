package org.example.repository;

import org.example.exception.NotFoundException;
import org.example.model.Bill;
import org.example.model.Order;
import org.example.model.Product;
import java.util.List;

public class BillRepository extends GenericRepositoryImpl<Bill>{

    public void save(Bill bill){
       dataSource.add(bill);
    }

    Order getOrderByBill(Bill bill){
        return dataSource.stream().filter(b -> b.equals(bill)).findFirst()
                .orElseThrow(() -> new NotFoundException("Bill could not found."))
                .getOrder();
    }

    List<Product> getProductsInBill(Bill bill){
        return bill.getOrder().getProducts();
    }
}
