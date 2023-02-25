package org.example.service;

import org.example.model.Customer;
import org.example.model.Order;

import java.util.List;
import java.util.Set;

public interface CustomerService extends BaseService<Customer>{
    Customer create(String firstName, String lastName);
    Customer create(String firstName, String lastName, String phone);
    Set<Order> getAllOrders();
    List<Customer> getAllContainsStr(String str);

    List<Customer> getAllByCreatedAtWithMonth(int month);
}
