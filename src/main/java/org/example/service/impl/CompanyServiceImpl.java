package org.example.service.impl;

import org.example.constant.ResultMessages;
import org.example.model.Company;
import org.example.model.Sector;
import org.example.repository.CompanyRepository;
import org.example.service.CompanyService;
import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company create(Sector sector, String name) {
        Company company = new Company(sector, name);
        companyRepository.save(company);
        System.out.println(ResultMessages.SUCCESSFUL_CREATE);
        return company;
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.getAll();
    }

    @Override
    public void delete(Company company) {
        companyRepository.delete(company);
        System.out.println(ResultMessages.SUCCESSFUL_DELETE);
    }
}
