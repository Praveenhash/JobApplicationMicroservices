package com.microservice.company.service;


import com.microservice.company.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    Company findCompanyById(Long id);

    void createCompany(Company company);

    boolean updateCompany(Long id, Company company);

    boolean deleteCompany(Long id);
}
