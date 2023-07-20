package com.naveen.bookmyshow.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionalHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleUsernameOrEmailAlreadyExists(UsernameOrEmailAlreadyExistsException ex, WebRequest request)
    {
        UsernameOrEmailAlreadyExistsResponse exceptionResponse = new UsernameOrEmailAlreadyExistsResponse(ex.getMessage(), ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);

    }
}
