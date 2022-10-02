package pl.niepracuj.model.entity;

import lombok.*;
import pl.niepracuj.model.enums.TechnologyEnum;

import javax.persistence.*;

@Entity
@Table(name = "technology")
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TechnologyEnum name;
}
