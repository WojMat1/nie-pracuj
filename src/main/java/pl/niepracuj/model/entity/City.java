package pl.niepracuj.model.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "cities")
@Setter
@Getter
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private State state;
}
