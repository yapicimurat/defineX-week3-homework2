package org.example.service.impl;

import org.example.constant.ResultMessages;
import org.example.model.*;
import org.example.repository.BillRepository;
import org.example.service.BillService;

import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class BillServiceImpl implements BillService {
    private final BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public List<Bill> getAll() {
        return billRepository.getAll();
    }

    @Override
    public void delete(Bill bill) {
        billRepository.delete(bill);
        System.out.println(ResultMessages.SUCCESSFUL_DELETE);
    }

    @Override
    public Bill create(String name, Order order) {
        Bill bill = new Bill(name, order);
        bill.setTotalPrice(order.getProducts().stream().mapToDouble(Product::getPrice).sum());

        billRepository.save(bill);
        System.out.println(ResultMessages.SUCCESSFUL_CREATE);
        return bill;
    }

    @Override
    public List<Bill> getAllByBiggerThanValue(double val) {
        return billRepository.getAll().stream().filter(bill -> bill.getTotalPrice() > val)
                .collect(Collectors.toList());
    }

    @Override
    public List<Bill> getAllBySmallerThanValue(double val) {
        return billRepository.getAll().stream().filter(bill -> bill.getTotalPrice() < val)
                .collect(Collectors.toList());
    }

    @Override
    public double getAverageByBiggerThanValue(double val) {
        return billRepository.getAll().stream().filter(bill -> bill.getTotalPrice() > val)
                .mapToDouble(Bill::getTotalPrice)
                .average().orElse(0.0);
    }

    @Override
    public boolean checkIfCompanyBillsAverageSmallerThanValueInGivenMonth(Company company, double val, int month){
        OptionalDouble result = getAllByCompany(company).stream()
                .filter(bill -> bill.getCreatedAt().getMonth() == Month.of(month))
                .mapToDouble(Bill::getTotalPrice)
                .average();

        return result.isPresent() && result.getAsDouble() < val;
    }

    public double getTotalPriceByCustomer(Customer customer){
        return billRepository.getAll().stream()
                .filter(bill -> bill.getOrder().getCustomer().equals(customer))
                .mapToDouble(Bill::getTotalPrice)
                .sum();
    }

    @Override
    public List<Bill> getAllByCompany(Company company) {
        return billRepository.getAll().stream().filter(bill -> bill.getOrder().
                        getProducts().stream().findFirst().get().getBrand().getCompany().equals(company))
                .collect(Collectors.toList());
    }
}
