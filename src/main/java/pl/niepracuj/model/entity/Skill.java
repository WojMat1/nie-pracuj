package pl.niepracuj.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "skills")
@Setter
@Getter
@NoArgsConstructor
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "skills")
    private Set<Advertisement> advertisements;

    @ManyToOne
    private Level level;

}
