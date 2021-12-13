package com.example.wallet.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BetAlreadyFinalizedAdvice {
    
    @ResponseBody
    @ExceptionHandler(BetAlreadyFinalizedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String betAlreadyFinalizedHandler(BetAlreadyFinalizedException ex) {
        return ex.getMessage();
    }
}
