package pl.niepracuj.model.mapper;

import org.springframework.stereotype.Component;
import pl.niepracuj.model.dto.CityDto;
import pl.niepracuj.model.entity.City;

@Component
public class CityMapper {

    public CityDto toDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .build();
    }

}