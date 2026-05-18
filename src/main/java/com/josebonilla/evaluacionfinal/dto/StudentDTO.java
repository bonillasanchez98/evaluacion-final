package com.josebonilla.evaluacionfinal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {

    private Integer idStudent;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 150)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 150)
    private String lastname;

    @NotNull
    @NotEmpty
    @Min(value = 9) @Max(value = 9)
    private String dni;
}
