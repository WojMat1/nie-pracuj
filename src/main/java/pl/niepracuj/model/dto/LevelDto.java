package pl.niepracuj.model.dto;

import lombok.*;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LevelDto {


    private Long id;

    private String name;

    private Integer score;
}
