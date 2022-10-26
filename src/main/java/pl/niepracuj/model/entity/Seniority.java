package pl.niepracuj.model.entity;

import lombok.*;
import pl.niepracuj.model.enums.SeniorityEnum;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "seniorities")
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Seniority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "name is mandatory")
    private SeniorityEnum name;
}
