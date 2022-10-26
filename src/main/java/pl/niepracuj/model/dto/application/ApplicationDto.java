package pl.niepracuj.model.dto.application;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import pl.niepracuj.model.entity.Advertisement;

import javax.persistence.ManyToOne;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String introduction;

    private String path;

}