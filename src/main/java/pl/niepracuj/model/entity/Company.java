package pl.niepracuj.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "company")
@Setter
@Getter
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private int size;

    private String email;

}
