package pl.niepracuj.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "companies")
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;

    private String address;

    private int size;
    @NotBlank(message = "Email is mandatory")
    private String email;

}
