package org.example.service.impl;

import org.example.constant.ResultMessages;
import org.example.model.Brand;
import org.example.model.Company;
import org.example.model.Product;
import org.example.repository.ProductRepository;
import org.example.service.ProductService;
import java.util.List;
import java.util.Set;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Set<Product> getAllByBrand(Brand brand) {
        return null;
    }

    @Override
    public Set<Product> getAllByCompany(Company company) {
        return null;
    }

    @Override
    public Product create(String name, double price, Brand brand) {
        Product product = new Product(name, price,brand);
        this.productRepository.save(product);
        System.out.println(ResultMessages.SUCCESSFUL_CREATE);
        return product;
    }

    @Override
    public void delete(Product product) {
        this.productRepository.delete(product);
        System.out.println(ResultMessages.SUCCESSFUL_DELETE);
    }
}
