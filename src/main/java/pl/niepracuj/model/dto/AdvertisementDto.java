package pl.niepracuj.model.dto;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
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

        private Long companyId;

        private Long technologyId;

        private Long seniorityId;

        private Timestamp publishDate;

        private Timestamp expireDate;

        private Long salaryFrom;

        private Long salaryTo;

        private String description;

        private Long cityID;

    }


