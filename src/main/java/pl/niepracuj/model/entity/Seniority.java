package pl.niepracuj.model.entity;

import lombok.*;
import pl.niepracuj.model.enums.SeniorityEnum;

import javax.persistence.*;


@Entity
@Table(name = "seniority")
@Setter
@Getter
@NoArgsConstructor
public class Seniority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SeniorityEnum name;
}
