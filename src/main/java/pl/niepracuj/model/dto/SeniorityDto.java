package pl.niepracuj.model.dto;

import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeniorityDto {


    private Long id;

    private String name;

}

