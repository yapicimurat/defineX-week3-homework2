package org.example.repository;

import org.example.model.Brand;
import org.example.model.Company;
import java.util.List;
import java.util.stream.Collectors;

public class BrandRepository extends GenericRepositoryImpl<Brand>{

    public List<Brand> getAllByCompany(Company company){
        return dataSource.stream()
                .filter(brand -> brand.getCompany().equals(company)).collect(Collectors.toList());
    }

}
