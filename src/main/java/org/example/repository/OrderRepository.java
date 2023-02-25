package org.example.repository;

import org.example.model.Customer;
import org.example.model.Order;
import java.util.List;
import java.util.stream.Collectors;

public class OrderRepository extends GenericRepositoryImpl<Order>{

    List<Order> getAllByCustomer(Customer customer){
        return dataSource.stream().filter(order -> order.getCustomer().equals(customer))
                .collect(Collectors.toList());
    }

}
