package com.josebonilla.evaluacionfinal.commons.exception;

import com.josebonilla.evaluacionfinal.commons.exception.error.ErrorResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class BusinessException extends RuntimeException {

    private final ErrorResult errorCode;

    public BusinessException(ErrorResult errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
