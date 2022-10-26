package pl.niepracuj.model.mapper;

import org.junit.jupiter.api.Test;
import pl.niepracuj.model.dto.CityDto;
import pl.niepracuj.model.entity.City;
import pl.niepracuj.model.entity.State;

import static org.junit.jupiter.api.Assertions.*;

class CityMapperTest {

    private CityMapper mapper = new CityMapper();

    @Test
    public void whenConvertCityEntityToCityDto_thenCorrect() {
        City city = new City();
        city.setId(1L);
        city.setName("Rzeszów");

        CityDto cityDto = mapper.toDto(city);
        assertEquals(city.getId(), cityDto.getId());
        assertEquals(city.getName(), cityDto.getName());
    }
}