package com.josebonilla.evaluacionfinal.commons.exception;

public class TechnicalException extends RuntimeException {
    protected TechnicalException( String message, Throwable cause ){
        super(message, cause);
    }
}
