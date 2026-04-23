package com.josebonilla.evaluacionfinal.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
public class EnrollmentDetail {

    private Course course;

    private String aula;
}
