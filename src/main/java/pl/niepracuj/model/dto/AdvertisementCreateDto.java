package pl.niepracuj.model.dto;

import lombok.*;

import java.time.Instant;
import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertisementCreateDto {




        private String name;

        private Long companyId;

        private Long technologyId;

        private Long seniorityId;

        private Instant expireDate;

        private Long salaryFrom;

        private Long salaryTo;

        private String description;

        private Long cityId;

        private Set<SkillCreateDto> skills;

    }


