package pl.niepracuj.model.mapper;

import org.junit.jupiter.api.Test;
import pl.niepracuj.model.dto.CompanyDto;
import pl.niepracuj.model.entity.Company;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompanyMapperTest {

    private CompanyMapper mapper = new CompanyMapper();

    @Test
    public void whenConvertCompanyEntityToCompanyDto_thenCorrect() {
        Company company = new Company();
        company.setId(1L);
        company.setName("Company");
        company.setEmail("company@email.com");
        company.setSize(100);
        company.setAddress("adres");

        CompanyDto companyDto = mapper.toDto(company);
        assertEquals(company.getId(), companyDto.getId());
        assertEquals(company.getName(), companyDto.getName());
        assertEquals(company.getEmail(), companyDto.getEmail());
        assertEquals(company.getAddress(), companyDto.getAddress());
        assertEquals(company.getSize(), companyDto.getSize());

    }

    @Test
    public void whenConvertCompanyDtoToCompanyEntity_thenCorrect() {
        CompanyDto companydto = new CompanyDto();
        companydto.setName("Company");
        companydto.setEmail("company@email.com");
        companydto.setSize(100);
        companydto.setAddress("adres");

        Company company = mapper.toNewEntity(companydto);

        assertEquals(company.getSize(), company.getSize());
        assertEquals(company.getEmail(), company.getEmail());
        assertEquals(company.getAddress(), company.getAddress());
        assertEquals(company.getSize(), company.getSize());
        assertEquals(companydto.getName(), company.getName());

    }
}