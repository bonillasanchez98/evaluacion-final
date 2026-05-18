package com.josebonilla.evaluacionfinal.commons.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
@Getter
public enum ErrorResult {

    ENTITY_NOT_FOUND("ENTITY_001", "Entity not found", HttpStatus.NOT_FOUND),
    ENTITY_NOT_NULL("ENTITY_002", "Null entity", HttpStatus.NOT_ACCEPTABLE),

    //Not show in client
    BUSINESS_EXCEPTION("BUSINESS_001", "Business exception", HttpStatus.INTERNAL_SERVER_ERROR),
    TECHNICAL_EXCEPTION("TECHNICAL_001", "Technical exception", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;
    private final String message;
    private final HttpStatus status;
    private final LocalDateTime dateTime = LocalDateTime.now();

}
