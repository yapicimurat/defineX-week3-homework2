package org.example.service;

import org.example.model.Brand;
import org.example.model.Company;

public interface BrandService extends BaseService<Brand>{

    Brand create(String name, Company company);
}
