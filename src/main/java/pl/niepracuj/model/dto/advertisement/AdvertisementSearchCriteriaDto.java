package pl.niepracuj.model.dto.advertisement;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.niepracuj.model.enums.SeniorityEnum;
import pl.niepracuj.model.enums.TechnologyEnum;

@Getter
@RequiredArgsConstructor
public class AdvertisementSearchCriteriaDto {


    private String name;

    private Long salaryFrom;

    private Long salaryTo;

    private String companyName;

    private TechnologyEnum technologyName;

    private SeniorityEnum seniorityName;

    private String cityName;

}
