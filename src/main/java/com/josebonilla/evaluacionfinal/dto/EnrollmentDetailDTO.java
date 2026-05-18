package com.josebonilla.evaluacionfinal.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDetailDTO {

    private Integer idEnrollmentDetail;

    @NotNull
    @JsonIncludeProperties(value = { "idCourse" })
    private CourseDTO courseDTO;

    @NotNull
    @NotEmpty
    private String aula;

    @JsonBackReference
    private EnrollmentDTO enrollmentDTO;

}
