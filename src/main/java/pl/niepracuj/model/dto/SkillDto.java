package pl.niepracuj.model.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillDto {


    private Long id;

    private String name;

    private Long levelId;

    private Set<AdvertisementDto> advertisements;

}
