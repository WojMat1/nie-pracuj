package pl.niepracuj.model.dto;

import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {


    private Long id;

    private String name;

    private String address;

    private int size;

    private String email;

}
