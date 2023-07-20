package com.naveen.bookmyshow.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsernameOrEmailAlreadyExistsException extends RuntimeException{

    public UsernameOrEmailAlreadyExistsException(String message)
    {
        super(message);
    }

}
