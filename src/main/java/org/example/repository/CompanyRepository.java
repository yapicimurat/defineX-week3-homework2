package org.example.repository;

import org.example.exception.NotFoundException;
import org.example.model.Brand;
import org.example.model.Company;
import org.example.model.Product;

public class CompanyRepository extends GenericRepositoryImpl<Company>{
    public Company getByBrand(Brand brand){
        return dataSource.stream().filter(company -> company.equals(brand.getCompany())).findFirst()
                .orElseThrow(() -> new NotFoundException("Company could not found."));
    }

    public Company getByProduct(Product product){
        return dataSource.stream().filter(company -> company.equals(product.getBrand().getCompany())).findFirst()
                .orElseThrow(() -> new NotFoundException("Company could not found."));
    }
}
