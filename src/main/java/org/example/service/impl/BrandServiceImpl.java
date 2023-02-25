package org.example.service.impl;

import org.example.constant.ResultMessages;
import org.example.model.Brand;
import org.example.model.Company;
import org.example.repository.BrandRepository;
import org.example.service.BrandService;

import java.util.List;

public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand create(String name, Company company) {
        Brand brand = new Brand(company, name);
        brandRepository.save(brand);
        System.out.println(ResultMessages.SUCCESSFUL_CREATE);
        return brand;
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.getAll();
    }

    @Override
    public void delete(Brand brand) {
        brandRepository.delete(brand);
        System.out.println(ResultMessages.SUCCESSFUL_DELETE);

    }
}
