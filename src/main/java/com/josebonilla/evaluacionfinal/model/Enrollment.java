package com.josebonilla.evaluacionfinal.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
public class Enrollment {

    private LocalDateTime enrollmentDate;

    private Student student;

    private List<EnrollmentDetail> enrollmentDetail;

    private boolean enabled;
}
