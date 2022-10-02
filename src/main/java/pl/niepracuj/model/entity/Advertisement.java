package pl.niepracuj.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "advertisements")
@Setter
@Getter
@NoArgsConstructor
public class Advertisement {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        @Column(name = "publish_date")
        private Instant publishDate;

        @Column(name = "expire_date")
        private Instant expireDate;

        @Column(name = "salary_from")
        private Long salaryFrom;

        @Column(name = "salary_to")
        private Long salaryTo;

        private String description;

        @ManyToOne
        @JoinColumn(name = "company_id", referencedColumnName = "id")
        private Company company;
        @ManyToMany
        @JoinTable(
                name = "adv_skills",
                joinColumns = @JoinColumn(name = "skill_id"),
                inverseJoinColumns = @JoinColumn(name = "adv_id")
        )
        private Set<Skill> skills;

        @ManyToOne
        @JoinColumn(name = "technology_id", referencedColumnName = "id")
        private Technology technology;

        @ManyToOne
        @JoinColumn(name = "seniority_id")
        private Seniority seniority;

        @ManyToOne
        @JoinColumn(name = "city_id", referencedColumnName = "id")
        private City city;


    }


