package pl.niepracuj.model.dto;

import lombok.*;
import pl.niepracuj.model.enums.SeniorityEnum;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeniorityDto {


    private Long id;

    private SeniorityEnum name;

}

