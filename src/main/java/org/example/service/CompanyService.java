package org.example.service;

import org.example.model.Brand;
import org.example.model.Company;
import org.example.model.Sector;

import java.util.Set;

public interface CompanyService extends BaseService<Company> {
    Company create(Sector sector, String name);
}
