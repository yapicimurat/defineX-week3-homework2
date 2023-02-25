package org.example.service;

import org.example.model.Bill;
import org.example.model.Company;
import org.example.model.Order;

import java.util.List;

public interface BillService extends BaseService<Bill>{

    Bill create(String name, Order order);
    List<Bill> getAllByBiggerThanValue(double val);
    List<Bill> getAllBySmallerThanValue(double val);
    double getAverageByBiggerThanValue(double val);
    boolean checkIfCompanyBillsAverageSmallerThanValueInGivenMonth(Company company, double val, int month);
    List<Bill> getAllByCompany(Company company);


}
