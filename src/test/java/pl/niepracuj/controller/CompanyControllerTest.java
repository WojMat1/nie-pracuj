package pl.niepracuj.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;
import pl.niepracuj.model.dto.CompanyDto;
import pl.niepracuj.service.company.CompanyService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@SqlGroup({
        @Sql(scripts = "/sql/controller/advertisement.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        @Sql(scripts = "/sql/controller/advertisement-cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
})
class CompanyControllerTest {

    @MockBean
    CompanyService companyService;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private MockMvc mockMvc;



    @Test
    void whenGetComapnies_thenReturnCompanies() throws Exception {
        //when & then
        mockMvc.perform(get("/company/all")).andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", Matchers.equalTo(2)));
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void shouldReturnCreatedCompany() throws Exception {
        CompanyDto company = new CompanyDto();
        company.setId(3L);
        company.setSize(100);
        company.setAddress("adres");
        company.setName("companyName");
        company.setEmail("email@company.com");
        //when & then
      String json = mapper.writeValueAsString(company);
        mockMvc.perform(post("/company/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


        }

    @Test
    @WithMockUser(username = "admin1", password = "admin1", roles = {"ADMIN"})
    void whenUseBadLogins_ShouldReturnClientError() throws Exception {
        CompanyDto company = new CompanyDto();
        company.setId(3L);
        company.setSize(100);
        company.setAddress("adres");
        company.setName("companyName");
        company.setEmail("email@company.com");
        //when & then
        String json = mapper.writeValueAsString(company);
        mockMvc.perform(post("/company/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());


    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenUseBadJson_ShouldReturn403Error() throws Exception {

        String json = "json: json";
        mockMvc.perform(post("/company/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().is4xxClientError());


    }

}


