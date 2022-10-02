package pl.niepracuj.mapper;

import org.springframework.stereotype.Component;
import pl.niepracuj.model.dto.CompanyDto;
import pl.niepracuj.model.entity.Company;

@Component
public class CompanyMapper {

    public CompanyDto toDto(Company company) {
        return CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .email(company.getEmail())
                .size(company.getSize())
                .address(company.getAddress())
                .build();
    }

    public Company ToNewEntity(CompanyDto companyDto) {
        return Company.builder()
                .name(companyDto.getName())
                .email(companyDto.getEmail())
                .size(companyDto.getSize())
                .address(companyDto.getAddress())
                .build();
    }


}
