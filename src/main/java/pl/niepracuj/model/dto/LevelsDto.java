package pl.niepracuj.model.dto;

import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LevelsDto {


    private Long id;

    private String name;

    private int score;
}
