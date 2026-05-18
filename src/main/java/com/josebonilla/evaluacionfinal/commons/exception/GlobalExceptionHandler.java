package com.josebonilla.evaluacionfinal.commons.exception;

import com.josebonilla.evaluacionfinal.commons.exception.error.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<CustomErrorResponse> handlerBusinessException(BusinessException ex, WebRequest req){

        CustomErrorResponse customErrorResponse = new CustomErrorResponse(
                LocalDateTime.now(),
                ex.getMessage(),
                req.getDescription(false),
                ErrorResult.BUSINESS_EXCEPTION
        );

        return new ResponseEntity<>(customErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<CustomErrorResponse> handlerSQLException(SQLException ex, WebRequest request){

        CustomErrorResponse customErrorResponse = new CustomErrorResponse(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                ErrorResult.TECHNICAL_EXCEPTION
        );

        return new ResponseEntity<>(customErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @Override
    protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                            HttpHeaders headers, HttpStatusCode status,
                                                                            WebRequest request) {

        String message = ex.getBindingResult().getFieldErrors()
                .stream().map( error -> error.getField() + " " + error.getDefaultMessage())
                .collect(Collectors.joining(" | "));

        CustomErrorResponse customErrorResponse = new CustomErrorResponse(
                LocalDateTime.now(),
                message,
                request.getDescription(false),
                ErrorResult.TECHNICAL_EXCEPTION
        );

        return new ResponseEntity<>(customErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected @Nullable ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex,
                                                                             HttpHeaders headers, HttpStatusCode status,
                                                                             WebRequest request) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                ErrorResult.TECHNICAL_EXCEPTION
        );

        return new ResponseEntity<>(customErrorResponse, HttpStatus.NOT_FOUND);
    }


}
