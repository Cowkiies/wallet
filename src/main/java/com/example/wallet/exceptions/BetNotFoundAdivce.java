package com.example.wallet.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class BetNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(BetNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String betNotFoundHandler(BetNotFoundException ex) {
        return ex.getMessage();
    }
}
