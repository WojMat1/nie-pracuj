package pl.niepracuj.model.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "levels")
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private Integer score;
}
