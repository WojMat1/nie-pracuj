package pl.niepracuj.model.dto;

import lombok.*;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillCreateDto {

    private String name;

    private Long levelId;



}
