package com.josebonilla.evaluacionfinal.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
public class EnrollmentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_course", nullable = false, foreignKey = @ForeignKey(name = "FK_ENROLLMENT_DETAIL_COURSE"))
    private Course course;

    @Column(nullable = false)
    private String aula;

    @ManyToOne
    @JoinColumn(name = "id_enrollment", nullable = false, foreignKey = @ForeignKey(name = "FK_ENROLLMENT_DETAIL_ENROLLMENT"))
    private Enrollment enrollment;
}
