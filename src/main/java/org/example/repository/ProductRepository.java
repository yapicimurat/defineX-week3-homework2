package org.example.repository;

import org.example.model.Brand;
import org.example.model.Company;
import org.example.model.Product;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository extends GenericRepositoryImpl<Product>{

    List<Product> getAllByBrand(Brand brand){
        return dataSource.stream().filter(product -> product.getBrand().equals(brand))
                .collect(Collectors.toList());
    }

    List<Product> getAllByCompany(Company company){
        return dataSource.stream().filter(product -> product.getBrand().getCompany().equals(company))
                .collect(Collectors.toList());
    }

}
