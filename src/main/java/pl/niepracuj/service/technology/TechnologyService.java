package pl.niepracuj.service.technology;

import pl.niepracuj.model.dto.CompanyDto;
import pl.niepracuj.model.dto.TechnologyDto;
import pl.niepracuj.model.entity.Technology;

import java.util.List;

public interface TechnologyService {

    List<TechnologyDto> getAllTechnologies();

    TechnologyDto createTechnology (TechnologyDto technologyDto);


}
