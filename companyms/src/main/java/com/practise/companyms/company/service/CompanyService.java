package com.practise.companyms.company.service;


import com.practise.companyms.company.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    void createCompany(Company company);

    Company findCompanyById(Long id);

    boolean deleteCompanyById(Long id);

    boolean updateCompany(Long id,Company company);

}
