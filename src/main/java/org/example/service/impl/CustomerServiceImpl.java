package org.example.service.impl;

import org.example.constant.ResultMessages;
import org.example.model.Customer;
import org.example.model.Order;
import org.example.repository.CustomerRepository;
import org.example.service.CustomerService;

import java.time.Month;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName);
        customerRepository.save(customer);
        System.out.println(ResultMessages.SUCCESSFUL_CREATE);
        return customer;
    }

    @Override
    public Customer create(String firstName, String lastName, String phone) {
        Customer customer = new Customer(firstName, lastName, phone);
        customerRepository.save(customer);
        System.out.println(ResultMessages.SUCCESSFUL_CREATE);
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
        System.out.println(ResultMessages.SUCCESSFUL_DELETE);
    }

    @Override
    public Set<Order> getAllOrders() {
        return null;
    }

    @Override
    public List<Customer> getAllContainsStr(String str) {
        return customerRepository.getAll().stream()
                .filter(customer -> customer.getFirstName().contains(str)).collect(Collectors.toList());
    }

    @Override
    public List<Customer> getAllByCreatedAtWithMonth(int month) {
        return customerRepository.getAll()
                .stream().filter(customer -> customer.getCreatedAt().getMonth() == Month.of(month))
                .collect(Collectors.toList());
    }
}
