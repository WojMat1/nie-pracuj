package pl.niepracuj.service;

import pl.niepracuj.model.dto.CompanyDto;

import java.util.List;

public interface CompanyService {

    List<CompanyDto> getAllCompanies();

    CompanyDto createCompany(CompanyDto companyDto);

    }

