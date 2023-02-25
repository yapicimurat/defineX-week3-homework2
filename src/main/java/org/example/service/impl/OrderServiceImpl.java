package org.example.service.impl;

import org.example.constant.ResultMessages;
import org.example.model.Customer;
import org.example.model.Order;
import org.example.model.Product;
import org.example.repository.OrderRepository;
import org.example.service.OrderService;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(String name, List<Product> productsList, Customer customer) {
        Order order = new Order(name, productsList, customer);
        order.setSum(productsList.stream().map(product -> product.getPrice()).reduce(0.0, Double::sum));
        orderRepository.save(order);
        System.out.println(ResultMessages.SUCCESSFUL_CREATE);
        return order;
    }

    @Override
    public List<Order> getAllByMonth(int month) {
        return orderRepository.getAll().stream().filter(order -> order.getCustomer().getCreatedAt().getMonth() == Month.of(month))
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
        System.out.println(ResultMessages.SUCCESSFUL_DELETE);
    }


}
