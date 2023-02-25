package org.example.service;

import org.example.model.Brand;
import org.example.model.Company;
import org.example.model.Product;

import java.util.List;
import java.util.Set;

public interface ProductService extends BaseService<Product>{
    Product create(String name, double price, Brand brand);
    List<Product> getAll();
    Set<Product> getAllByBrand(Brand brand);
    Set<Product> getAllByCompany(Company company);
}
