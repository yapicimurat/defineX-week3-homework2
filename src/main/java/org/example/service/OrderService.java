package org.example.service;

import org.example.model.Customer;
import org.example.model.Order;
import org.example.model.Product;

import java.util.List;

public interface OrderService extends BaseService<Order> {
    Order create(String name, List<Product> productList, Customer customer);

    List<Order> getAllByMonth(int month);
}
