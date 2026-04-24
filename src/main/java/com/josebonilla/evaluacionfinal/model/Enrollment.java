package com.josebonilla.evaluacionfinal.model;

import jakarta.persistence.*;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime enrollmentDate;

    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false, foreignKey = @ForeignKey(name = "FK_ENROLLMENT_STUDENT"))
    private Student student;

    @OneToMany(mappedBy = "enrollment", cascade = CascadeType.ALL)
    private List<EnrollmentDetail> enrollmentDetail;

    @Column(nullable = false)
    private boolean enabled;
}
