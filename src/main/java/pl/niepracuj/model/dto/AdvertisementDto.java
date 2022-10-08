package pl.niepracuj.model.dto;

import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertisementDto {

        private Long id;

        private Set<SkillDto> skills;

        private String name;

        private CompanyDto company;

        private TechnologyDto technology;

        private SeniorityDto seniority;

        private LocalDateTime publishDate;

        private LocalDateTime expireDate;

        private Long salaryFrom;

        private Long salaryTo;

        private String description;

        private CityDto city;

    }


